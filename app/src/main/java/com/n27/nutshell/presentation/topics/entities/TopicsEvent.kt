package com.n27.nutshell.presentation.topics.entities

sealed class TopicsEvent {

    data object GoToNextScreen : TopicsEvent()
}