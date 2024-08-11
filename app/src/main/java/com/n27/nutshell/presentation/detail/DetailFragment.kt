package com.n27.nutshell.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import com.n27.nutshell.R
import com.n27.nutshell.presentation.detail.composables.DetailScreen
import com.n27.nutshell.presentation.detail.entities.DetailUiState
import com.n27.nutshell.presentation.detail.entities.DetailUiState.Content.NavItem

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            DetailScreen(
                DetailUiState.Content(
                    navItems = listOf(
                        NavItem(
                            content = "Informacion sobre IRPF",
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            label = "IRPF"
                        ),
                        NavItem(
                            content = "Informacion sobre IVA",
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            label = "IVA"
                        )
                    )
                )
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(R.id.action_DetailFragment_to_TopicsFragment)
        }
    }
}