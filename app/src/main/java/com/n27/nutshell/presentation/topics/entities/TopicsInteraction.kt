package com.n27.nutshell.presentation.topics.entities

sealed class TopicsInteraction {

    data object NextButtonClicked : TopicsInteraction()
}