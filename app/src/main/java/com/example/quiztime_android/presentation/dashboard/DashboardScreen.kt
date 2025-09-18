package com.example.quiztime_android.presentation.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
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
    state: DashboardStates // Used for the values that can change during using the application, name, and questions attempted
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Hello",
            style = MaterialTheme.typography.bodyMedium
        )
        Row {
            Text(
                text = state.userName,
                style = MaterialTheme.typography.headlineMedium
            )
            IconButton(
                modifier = Modifier.offset(x = (-10).dp, y = (-20).dp),
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(R.drawable.ic_edit),
                    contentDescription = "Edit Name"
                )
            }
        }
        UserStatisticsCard(
            questionsAttempted = state.questionAttempts,
            correctAnswers = state.correctAnswers
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewDashboardScreen(
    modifier: Modifier = Modifier
) {
    DashboardScreen(
        state = DashboardStates()
    )
}