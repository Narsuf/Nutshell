package org.n27.nutshell.di

import dagger.Component
import org.n27.nutshell.data.di.DataModule
import org.n27.nutshell.presentation.MainActivity
import org.n27.nutshell.presentation.detail.DetailFragment
import org.n27.nutshell.presentation.topics.TopicsFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(topicsFragment: TopicsFragment)
    fun inject(detailFragment: DetailFragment)
}