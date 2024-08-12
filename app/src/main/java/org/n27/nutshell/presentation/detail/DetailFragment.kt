package org.n27.nutshell.presentation.detail

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
import org.n27.nutshell.extensions.observeOnLifecycle
import org.n27.nutshell.presentation.MainActivity
import org.n27.nutshell.presentation.detail.composables.DetailScreen
import org.n27.nutshell.presentation.detail.entities.DetailAction.GetNavIcons
import org.n27.nutshell.presentation.detail.entities.DetailEvent
import org.n27.nutshell.presentation.detail.entities.DetailEvent.OpenUrl
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
            DetailScreen(args.title, uiState, onAction = viewModel::handleAction)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            viewEvent.observeOnLifecycle(viewLifecycleOwner, action = ::handleEvent)
            handleAction(GetNavIcons)
        }

        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(R.id.action_DetailFragment_to_TopicsFragment)
        }
    }

    private fun handleEvent(event: DetailEvent) = when (event) {
        is OpenUrl -> openUrl(event.url)
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(url) }
        startActivity(intent)
    }
}