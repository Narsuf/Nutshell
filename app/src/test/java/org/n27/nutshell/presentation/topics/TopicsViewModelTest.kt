package org.n27.nutshell.presentation.topics

import com.n27.nutshell.domain.getTopics
import com.n27.nutshell.presentation.getTopicsContent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.plus
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.n27.nutshell.data.NutshellRepositoryImpl
import org.n27.nutshell.presentation.test
import org.n27.nutshell.presentation.topics.entities.TopicsAction.NextButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsAction.RetryButtonClicked
import org.n27.nutshell.presentation.topics.entities.TopicsEvent.GoToNextScreen
import org.n27.nutshell.presentation.topics.entities.TopicsUiState.Loading
import kotlin.Result.Companion.success

@ExperimentalCoroutinesApi
internal class TopicsViewModelTest {

    private val repository: NutshellRepositoryImpl = mock()
    private val tracker: TopicsTracker = mock()

    @Before
    fun init() = runTest {
        Dispatchers.setMain(StandardTestDispatcher())

        `when`(repository.getTopics()).thenReturn(success(getTopics()))
    }

    @Test
    fun `should emit loading and content state when init`() = runTest {
        val expected = getTopicsContent()
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))

        runCurrent()

        observer.assertValues(Loading, expected)
        observer.close()
    }

    @Test
    fun `should emit loading and content state when retry`() = runTest {
        val expected = getTopicsContent()
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))

        viewModel.handleAction(RetryButtonClicked)
        runCurrent()

        observer.assertValues(Loading, expected, Loading, expected)
        observer.close()
    }

    @Test
    fun `should emit go to next screen when next button clicked`() = runTest {
        val viewModel = getViewModel()
        val observer = viewModel.viewEvent.test(this + UnconfinedTestDispatcher(testScheduler))

        viewModel.handleAction(NextButtonClicked(KEY, TITLE))
        runCurrent()

        observer.assertValues(GoToNextScreen(KEY, TITLE))
        observer.close()
    }

    private fun getViewModel() = TopicsViewModel(repository, tracker)

    private companion object {
        private const val KEY = "taxes"
        private const val TITLE = "Taxes in Europe"
    }
}
