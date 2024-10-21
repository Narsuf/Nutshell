package org.n27.nutshell.detail.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.n27.nutshell.R
import org.n27.nutshell.common.presentation.MainActivity
import org.n27.nutshell.common.presentation.composables.theme.Theme
import org.n27.nutshell.common.presentation.extensions.observeOnLifecycle
import org.n27.nutshell.detail.presentation.composables.DetailScreen
import org.n27.nutshell.detail.presentation.entities.DetailAction.GetDetail
import org.n27.nutshell.detail.presentation.entities.DetailEvent
import org.n27.nutshell.detail.presentation.entities.DetailEvent.GoBack
import org.n27.nutshell.detail.presentation.entities.DetailEvent.OpenUrl
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

    @Inject lateinit var assistedFactory: DetailViewModel.Factory

    private val viewModel: DetailViewModel by viewModels {
        DetailViewModelFactory(assistedFactory, args.key)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            Theme {
                DetailScreen(args.title, uiState, onAction = viewModel::handleAction)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            viewEvent.observeOnLifecycle(viewLifecycleOwner, action = ::handleEvent)
            handleAction(GetDetail)
        }

        requireActivity().onBackPressedDispatcher.addCallback { goBack() }
    }

    private fun handleEvent(event: DetailEvent) = when (event) {
        GoBack -> goBack()
        is OpenUrl -> openUrl(event.url)
    }

    private fun goBack() {
        findNavController().navigate(R.id.action_DetailFragment_to_TopicsFragment)
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(url) }
        startActivity(intent)
    }
}
