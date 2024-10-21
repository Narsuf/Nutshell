package org.n27.nutshell.di

import dagger.Component
import org.n27.nutshell.common.data.di.DataModule
import org.n27.nutshell.common.presentation.MainActivity
import org.n27.nutshell.common.presentation.di.PresentationModule
import org.n27.nutshell.detail.presentation.DetailFragment
import org.n27.nutshell.detail.presentation.di.ViewModelModule
import org.n27.nutshell.topics.presentation.TopicsFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        PresentationModule::class,
        ViewModelModule::class,
        DataModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(topicsFragment: TopicsFragment)
    fun inject(detailFragment: DetailFragment)
}
