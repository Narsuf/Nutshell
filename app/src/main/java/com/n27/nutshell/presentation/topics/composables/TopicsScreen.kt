package com.n27.nutshell.presentation.topics.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.n27.nutshell.R
import com.n27.nutshell.presentation.common.composables.Toolbar

@Composable
fun TopicsScreen() {
    Scaffold(
        topBar = {
            Toolbar(text = stringResource(R.string.topics_fragment_label))
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Button(onClick = {}) { Text(stringResource(R.string.next)) }
            Text(stringResource(R.string.lorem_ipsum))
        }
    }
}
