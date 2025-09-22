package com.example.quiztime_android.presentation.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztime_android.R
import com.example.quiztime_android.presentation.dashboard.component.UserStatisticsCard

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    state: DashboardState // Used for the values that can change during using the application, name, and questions attempted
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderSection(
            modifier = Modifier
                .padding(top = 40.dp, start = 10.dp, end = 10.dp),
            username = state.userName,
            questionAttempted = state.questionAttempted,
            correctAnswers = state.questionAttempted,
            onEditNameClick = {}
        )
    }
}

@Composable
private fun HeaderSection(
    modifier: Modifier = Modifier,
    username: String,
    questionAttempted: Int,
    correctAnswers: Int,
    onEditNameClick: () -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = "Hello",
            style = MaterialTheme.typography.bodyMedium
        )
        Row {
            Text(
                text = username,
                style = MaterialTheme.typography.headlineMedium
            )
            IconButton(
                modifier = Modifier.offset(x = (-10).dp, y = (-20).dp),
                onClick = onEditNameClick
            ) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(R.drawable.ic_edit),
                    contentDescription = "Edit Name"
                )
            }
        }
        UserStatisticsCard(
            questionsAttempted = questionAttempted,
            correctAnswers = correctAnswers
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDashboardScreen() {
    val state = DashboardState(
        questionAttempted = 10,
        correctAnswers = 7
    )
    DashboardScreen(
        state = state
    )
}