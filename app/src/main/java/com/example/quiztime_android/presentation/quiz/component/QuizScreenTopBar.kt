package com.example.quiztime_android.presentation.quiz.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.quiztime_android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreenTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onExitQuizButtonClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(title) },
        actions = {
            IconButton(onClick = onExitQuizButtonClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_close),
                    contentDescription = "Exit Quiz"
                )
            }
        }
    )
}

@Preview
@Composable
private fun PreviewQuizScreenTopBar() {
    QuizScreenTopBar(
        title = "Android Quiz",
        onExitQuizButtonClick = {}
    )
}