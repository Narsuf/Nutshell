package org.n27.nutshell.presentation.topics

import com.n27.nutshell.domain.getTopics
import com.n27.nutshell.presentation.getTopicsContent
import com.n27.nutshell.presentation.getTopicsError
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
import org.n27.nutshell.common.data.repository.NutshellRepositoryImpl
import org.n27.nutshell.topics.presentation.entities.TopicsAction.NextButtonClicked
import org.n27.nutshell.topics.presentation.entities.TopicsAction.RetryButtonClicked
import org.n27.nutshell.topics.presentation.entities.TopicsEvent.GoToNextScreen
import org.n27.nutshell.topics.presentation.entities.TopicsUiState.Loading
import org.n27.nutshell.test
import org.n27.nutshell.topics.presentation.TopicsTracker
import org.n27.nutshell.topics.presentation.TopicsViewModel
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

@ExperimentalCoroutinesApi
internal class TopicsViewModelTest {

    private val repository: NutshellRepositoryImpl = mock()
    private val tracker: TopicsTracker = mock()

    @Before
    fun init() { Dispatchers.setMain(StandardTestDispatcher()) }

    @Test
    fun `should emit loading and content state when init`() = runTest {
        val expected = getTopicsContent()
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))

        `when`(repository.getTopics()).thenReturn(success(getTopics()))

        runCurrent()

        observer.assertValues(Loading, expected)
        observer.close()
    }

    @Test
    fun `should emit loading and content state when retry`() = runTest {
        val expected = getTopicsContent()
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))

        `when`(repository.getTopics()).thenReturn(success(getTopics()))

        viewModel.handleAction(RetryButtonClicked)
        runCurrent()

        observer.assertValues(Loading, expected, Loading, expected)
        observer.close()
    }

    @Test
    fun `should emit go to next screen when next button clicked`() = runTest {
        val viewModel = getViewModel()
        val observer = viewModel.viewEvent.test(this + UnconfinedTestDispatcher(testScheduler))

        `when`(repository.getTopics()).thenReturn(success(getTopics()))

        viewModel.handleAction(NextButtonClicked(KEY, TITLE))
        runCurrent()

        observer.assertValues(GoToNextScreen(KEY, TITLE))
        observer.close()
    }

    @Test
    fun `should emit error when failure`() = runTest {
        val expected = getTopicsError()
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))

        `when`(repository.getTopics()).thenReturn(failure(Throwable()))

        runCurrent()

        observer.assertValues(Loading, expected)
        observer.close()
    }

    private fun getViewModel() = TopicsViewModel(repository, tracker)

    private companion object {
        private const val KEY = "taxes"
        private const val TITLE = "Taxes in Europe"
    }
}
