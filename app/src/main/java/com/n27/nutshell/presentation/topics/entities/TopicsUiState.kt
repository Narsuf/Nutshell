package com.n27.nutshell.presentation.topics.entities

sealed class TopicsUiStates {

    data class Content(val cardList: List<Card>) : TopicsUiStates() {

        data class Card(
            val title: String,
            val imageUrl: String
        )
    }
}