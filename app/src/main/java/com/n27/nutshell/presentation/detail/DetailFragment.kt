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
import com.n27.nutshell.presentation.detail.entities.DetailUiState.Content.Info
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
                    title = "Taxes",
                    infoList = listOf(
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "España",
                            value = "54"
                        ),
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "Alemania",
                            value = "47.5"
                        ),
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "Alemania1",
                            value = "47.5"
                        ),
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "Alemania2",
                            value = "47.5"
                        ),
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "Alemania3",
                            value = "47.5"
                        ),
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "Alemania4",
                            value = "47.5"
                        ),
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "Alemania5",
                            value = "47.5"
                        ),
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "Alemania6",
                            value = "47.5"
                        ),
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "Alemania7",
                            value = "47.5"
                        ),
                        Info(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            text = "Alemania8",
                            value = "47.5"
                        )
                    ),
                    sourceUrl = "",
                    navItems = listOf(
                        NavItem(
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                            label = "IRPF"
                        ),
                        NavItem(
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