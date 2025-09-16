package com.example.quiztime_android.presentation.dashboard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztime_android.presentation.theme.CustomBlue
import com.example.quiztime_android.presentation.theme.CustomPink

@Composable
fun UserStatisticsCard(
    modifier : Modifier = Modifier,
    questionsAttempted : Int,
    correctAnswers : Int
) {
    val barProgress = if (questionsAttempted > 0) { // we only calculate if we have tried at least 1 question
        correctAnswers.toFloat() / questionsAttempted
    } else 0f

    ProgressBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(15.dp),
        barProgress = barProgress
    )
}

@Composable
private fun ProgressBar(
    modifier: Modifier = Modifier,
    // Calculate the bar progress from correct answers
    barProgress : Float,
    gradientColors : List<Color> = listOf(CustomPink, CustomBlue)
) {
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.extraSmall)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(barProgress)
                .fillMaxHeight()
                .clip(MaterialTheme.shapes.extraSmall)
                .background(Brush.linearGradient(gradientColors))
        )
        Box(
            modifier = Modifier
                .padding(end = 5.dp)
                .align(Alignment.CenterEnd)
                .size(5.dp)
                .clip(CircleShape)
                .background(Brush.linearGradient(gradientColors))
        )
    }
}

@Preview
@Composable
private fun PreviewStatisticsCard() {
    UserStatisticsCard(
        questionsAttempted = 10,
        correctAnswers = 7
    )
}