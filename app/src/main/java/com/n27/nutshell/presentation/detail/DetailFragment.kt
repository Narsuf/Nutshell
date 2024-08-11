package com.n27.nutshell.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.n27.nutshell.R
import com.n27.nutshell.presentation.detail.composables.DetailScreen
import com.n27.nutshell.presentation.detail.entities.DetailUiState
import com.n27.nutshell.presentation.detail.entities.DetailUiState.Content.Info
import com.n27.nutshell.presentation.detail.entities.DetailUiState.Content.NavItem

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()

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
                            iconUrl = "http://cdn-icons-png.flaticon.com/128/197/197593.png",
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
                ),
                onClick = ::openUrl
            )
        }
    }

    private fun openUrl() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://www.eleconomista.es/economia/noticias/12698991/02/24/espana-es-el-cuarto-pais-de-europa-con-el-irpf-maximo-mas-elevado-para-la-rentas-altas.html")
        }

        startActivity(intent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val key = args.key

        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(R.id.action_DetailFragment_to_TopicsFragment)
        }
    }
}