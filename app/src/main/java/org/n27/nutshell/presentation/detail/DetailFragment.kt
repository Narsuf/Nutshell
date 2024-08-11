package org.n27.nutshell.presentation.detail

import android.content.Context
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
import org.n27.nutshell.R
import org.n27.nutshell.extensions.observeOnLifecycle
import org.n27.nutshell.presentation.MainActivity
import org.n27.nutshell.presentation.detail.composables.DetailScreen
import org.n27.nutshell.presentation.detail.entities.DetailEvent
import org.n27.nutshell.presentation.detail.entities.DetailEvent.OpenUrl
import org.n27.nutshell.presentation.detail.entities.DetailUiState
import org.n27.nutshell.presentation.detail.entities.DetailUiState.Content.Info
import org.n27.nutshell.presentation.detail.entities.DetailUiState.Content.NavItem
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailFragment : Fragment() {

    @Inject lateinit var viewModel: DetailViewModel

    private val args: DetailFragmentArgs by navArgs()

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
                    sourceUrl = "https://www.eleconomista.es/economia/noticias/12698991/02/24/espana-es-el-cuarto-pais-de-europa-con-el-irpf-maximo-mas-elevado-para-la-rentas-altas.html",
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
                onAction = viewModel::handleAction
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val key = args.key

        viewModel.viewEvent.observeOnLifecycle(viewLifecycleOwner, action = ::handleEvent)

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