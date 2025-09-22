package com.example.quiztime_android.presentation.dashboard.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztime_android.R

@Composable
fun TopicCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(R.drawable.ic_play),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Android",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview
@Composable
private fun PreviewTopicCard() {
    TopicCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    )
}