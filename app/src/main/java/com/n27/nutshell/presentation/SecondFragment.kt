package com.n27.nutshell.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import com.n27.nutshell.R
import com.n27.nutshell.presentation.common.composables.NavItem

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            BottomNavigation(backgroundColor = MaterialTheme.colors.background) {
                listOf(
                    NavItem(
                        isSelected = false,
                        onClick = {
                            findNavController().navigate(R.id.action_SecondFragment_to_TopicsFragment)
                        },
                        imageUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                        label = "Topics"
                    ),
                    NavItem(
                        isSelected = true,
                        onClick = {},
                        imageUrl = "http://cdn-icons-png.flaticon.com/128/6049/6049398.png",
                        label = "Second"
                    )
                )
            }
        }
    }
}