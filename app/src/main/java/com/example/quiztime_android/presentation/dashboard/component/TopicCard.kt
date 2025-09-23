package com.example.quiztime_android.presentation.dashboard.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.quiztime_android.R

@Composable
fun TopicCard(
    modifier: Modifier = Modifier,
    topicName: String,
    imageUrl: String,
    onClick: () -> Unit // to be clickable
) {
    Box {
        Card(
            modifier = modifier.clickable { onClick() }
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Icon(
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .size(20.dp),
                    painter = painterResource(R.drawable.ic_play),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = topicName,
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        TopicImage(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 10.dp)
                .size(100.dp)
                .offset(y = (-20).dp),
            imageUrl = imageUrl
        )
    }
}

@Composable
private fun TopicImage(
    modifier: Modifier = Modifier,
    imageUrl: String // provide the image URL thru parameter
) {
    val context = LocalContext.current
    val imageRequest = ImageRequest
        .Builder(context)
        .data(imageUrl) // Image URL
        .crossfade(enable = true) // fading animation
        .build()

    AsyncImage(
        modifier = modifier,
        model = imageRequest, // define Image request
        contentDescription = null,
        alignment = Alignment.TopCenter,
        placeholder = painterResource(R.drawable.img_topic_placeholder), // we can define one image while the actual is loading
        error = painterResource(R.drawable.img_topic_placeholder)
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewTopicCard() {
    TopicCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        topicName = "Android",
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAq_P6bFIFwZjrDzPNwbHvz4dRRmq8ihzADg&s", // coming from the internet, why not from our server?
        onClick = {}
    )
}