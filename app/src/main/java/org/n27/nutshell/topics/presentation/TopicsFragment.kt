package org.n27.nutshell.topics.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.fragment.findNavController
import org.n27.nutshell.common.presentation.MainActivity
import org.n27.nutshell.common.presentation.composables.theme.Theme
import org.n27.nutshell.common.presentation.extensions.observeOnLifecycle
import org.n27.nutshell.topics.presentation.composables.TopicsScreen
import org.n27.nutshell.topics.presentation.entities.TopicsEvent
import org.n27.nutshell.topics.presentation.entities.TopicsEvent.GoToNextScreen
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
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            Theme {
                TopicsScreen(uiState, onAction = viewModel::handleAction)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewEvent.observeOnLifecycle(viewLifecycleOwner, action = ::handleEvent)
        requireActivity().onBackPressedDispatcher.addCallback { requireActivity().finish() }
    }

    private fun handleEvent(event: TopicsEvent) = when (event) {
        is GoToNextScreen -> goToNextScreen(event.key, event.title)
    }

    private fun goToNextScreen(key: String, title: String) {
        val action = TopicsFragmentDirections.actionTopicsFragmentToDetailFragment(key, title)
        findNavController().navigate(action)
    }
}
