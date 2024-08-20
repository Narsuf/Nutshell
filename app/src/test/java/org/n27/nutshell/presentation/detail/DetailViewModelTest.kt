package org.n27.nutshell.presentation.detail

import com.n27.nutshell.domain.getDetail
import com.n27.nutshell.domain.getInfo
import com.n27.nutshell.presentation.getError
import com.n27.nutshell.presentation.getHasContent
import com.n27.nutshell.presentation.getNoContent
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
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.n27.nutshell.data.NutshellRepositoryImpl
import org.n27.nutshell.presentation.common.test
import org.n27.nutshell.presentation.detail.entities.DetailAction.BackClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.GetDetail
import org.n27.nutshell.presentation.detail.entities.DetailAction.InfoClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.NavItemClicked
import org.n27.nutshell.presentation.detail.entities.DetailAction.RetryClicked
import org.n27.nutshell.presentation.detail.entities.DetailEvent.GoBack
import org.n27.nutshell.presentation.detail.entities.DetailEvent.OpenUrl
import kotlin.Result.Companion.failure
import kotlin.Result.Companion.success

@ExperimentalCoroutinesApi
internal class DetailViewModelTest {

    private val repository: NutshellRepositoryImpl = mock()
    private val tracker: DetailTracker = mock()

    @Before
    fun init() { Dispatchers.setMain(StandardTestDispatcher()) }

    @Test
    fun `should emit no content and content state when get detail`() = runTest {
        val expected = getHasContent()
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))

        `when`(repository.getDetail(anyString())).thenReturn(success(getDetail()))

        viewModel.handleAction(GetDetail)
        runCurrent()

        observer.assertValues(getNoContent(), expected)
        observer.close()
    }

    @Test
    fun `should emit no content and content state when retry`() = runTest {
        val expected = getHasContent()
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))

        `when`(repository.getDetail(anyString())).thenReturn(success(getDetail()))

        viewModel.handleAction(RetryClicked)
        runCurrent()

        observer.assertValues(getNoContent(), expected)
        observer.close()
    }

    @Test
    fun `should emit go back when back button clicked`() = runTest {
        val viewModel = getViewModel()
        val observer = viewModel.viewEvent.test(this + UnconfinedTestDispatcher(testScheduler))

        viewModel.handleAction(BackClicked)
        runCurrent()

        observer.assertValues(GoBack)
        observer.close()
    }

    @Test
    fun `should emit open url when info button clicked`() = runTest {
        val viewModel = getViewModel()
        val observer = viewModel.viewEvent.test(this + UnconfinedTestDispatcher(testScheduler))

        viewModel.handleAction(InfoClicked(URL, null))
        runCurrent()

        observer.assertValues(OpenUrl(URL))
        observer.close()
    }

    @Test
    fun `should emit content state when tab clicked`() = runTest {
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))
        val expected = getHasContent(
            info = getInfo(
                iconUrl = "http://fake.spain.flag.icon.url.com",
                text = "Spain",
                value = "54"
            )
        )

        `when`(repository.getDetail(anyString())).thenReturn(success(getDetail()))

        viewModel.handleAction(GetDetail)
        runCurrent()

        viewModel.handleAction(NavItemClicked(1, "Income"))
        runCurrent()

        observer.assertValues(getNoContent(), getHasContent(), expected)
        observer.close()
    }

    @Test
    fun `should emit no content when get detail fails`() = runTest {
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))
        val expected = getNoContent(
            isLoading = false,
            error = getError()
        )

        `when`(repository.getDetail(anyString())).thenReturn(failure(Throwable()))

        viewModel.handleAction(GetDetail)
        runCurrent()

        observer.assertValues(getNoContent(), expected)
        observer.close()
    }

    @Test
    fun `should emit no content when get detail returns empty tabs`() = runTest {
        val viewModel = getViewModel()
        val observer = viewModel.uiState.test(this + UnconfinedTestDispatcher(testScheduler))
        val expected = getNoContent(
            isLoading = false,
            error = getError()
        )

        `when`(repository.getDetail(anyString())).thenReturn(success(getDetail(tabs = listOf())))

        viewModel.handleAction(GetDetail)
        runCurrent()

        observer.assertValues(getNoContent(), expected)
        observer.close()
    }

    private fun getViewModel() = DetailViewModel(KEY, repository, tracker)

    private companion object {
        private const val KEY = "taxes"
        private const val URL = "http://fake.source.url.com"
    }
}
