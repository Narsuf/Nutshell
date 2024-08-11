package org.n27.nutshell.presentation.topics

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import org.n27.nutshell.extensions.observeOnLifecycle
import org.n27.nutshell.presentation.MainActivity
import org.n27.nutshell.presentation.topics.composables.TopicsScreen
import org.n27.nutshell.presentation.topics.entities.TopicsEvent
import org.n27.nutshell.presentation.topics.entities.TopicsEvent.GoToNextScreen
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TopicsFragment : Fragment() {

    @Inject lateinit var viewModel: TopicsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            val uiState by viewModel.viewState.collectAsStateWithLifecycle()
            TopicsScreen(uiState, onAction = viewModel::handleAction)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewEvent.observeOnLifecycle(viewLifecycleOwner, action = ::handleEvent)
        requireActivity().onBackPressedDispatcher.addCallback { requireActivity().finish() }
    }

    private fun handleEvent(event: TopicsEvent) = when (event) {
        is GoToNextScreen -> goToNextScreen(event.key)
    }

    private fun goToNextScreen(key: String) {
        val action = TopicsFragmentDirections.actionTopicsFragmentToDetailFragment(key)
        findNavController().navigate(action)
    }
}