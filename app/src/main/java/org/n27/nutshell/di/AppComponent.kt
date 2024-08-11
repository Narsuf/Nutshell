package org.n27.nutshell.di

import org.n27.nutshell.presentation.MainActivity
import org.n27.nutshell.presentation.detail.DetailFragment
import org.n27.nutshell.presentation.topics.TopicsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(topicsFragment: TopicsFragment)
    fun inject(detailFragment: DetailFragment)
}