package com.n27.nutshell.di

import com.n27.nutshell.presentation.MainActivity
import com.n27.nutshell.presentation.topics.TopicsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(topicsFragment: TopicsFragment)
}