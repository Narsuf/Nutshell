package com.n27.nutshell.presentation.topics.entities

sealed class TopicsAction {

    data object NextButtonClicked : TopicsAction()
}