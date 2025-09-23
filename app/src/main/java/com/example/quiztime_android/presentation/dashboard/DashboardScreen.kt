package com.example.quiztime_android.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.quiztime_android.R
import com.example.quiztime_android.domain.model.QuizTopic
import com.example.quiztime_android.presentation.common_component.ErrorScreen
import com.example.quiztime_android.presentation.dashboard.component.NameEditDialog
import com.example.quiztime_android.presentation.dashboard.component.ShimmerEffect
import com.example.quiztime_android.presentation.dashboard.component.TopicCard
import com.example.quiztime_android.presentation.dashboard.component.UserStatisticsCard

@Composable
fun DashboardScreen(
    state: DashboardState // Used for the values that can change during using the application, name, and questions attempted
) {

    NameEditDialog(
        isOpen = state.isNameEditDialogOpen,
        textFieldValue = state.usernameTextFieldValue,
        userNameError = state.usernameError,
        onDialogDismiss = {},
        onConfirmButtonClick = {},
        onTextFieldValueChange = {}
    )

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderSection(
            modifier = Modifier
                .fillMaxWidth(),
            username = state.userName,
            questionAttempted = state.questionAttempted,
            correctAnswers = state.questionAttempted,
            onEditNameClick = {}
        )
        QuizTopicSection(
            modifier = Modifier.fillMaxWidth(),
            quizTopics = state.quizTopics,
            isTopicsLoading = state.isLoading,
            errorMessage = state.errorMessage,
            onRefreshIconClick = {}
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun HeaderSection(
    modifier: Modifier = Modifier,
    username: String,
    questionAttempted: Int,
    correctAnswers: Int,
    onEditNameClick: () -> Unit
) {
    FlowRow ( // used for landscape view
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier
            .padding(top = 40.dp, start = 10.dp, end = 10.dp)
        ) {
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
        }
        UserStatisticsCard(
            modifier = Modifier
                .widthIn(max = 400.dp)
                .padding(10.dp),
            questionsAttempted = questionAttempted,
            correctAnswers = correctAnswers
        )
    }

}

@Composable
private fun QuizTopicSection(
    modifier: Modifier = Modifier,
    quizTopics: List<QuizTopic>,
    isTopicsLoading: Boolean,
    errorMessage: String?,
    onRefreshIconClick: () -> Unit
) {
    Column (modifier = modifier) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "What topic do you want to improve today?",
            style = MaterialTheme.typography.titleLarge
        )
        if (errorMessage != null){ // in this case we have some error
            ErrorScreen(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                errorMessage = errorMessage,
                onRefreshIconClick = onRefreshIconClick
            )
        } else { // if we don't have error
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                contentPadding = PaddingValues(15.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                if (isTopicsLoading) {
                    items(count = 6) {
                        ShimmerEffect(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp)
                                .clip(MaterialTheme.shapes.small)
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                        )
                    }
                } else {
                    items(quizTopics) { topic -> // we need to provide our topics number
                        TopicCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(120.dp),
                            topicName = topic.name,
                            imageUrl = topic.imageUrl,
                            onClick = {}
                        )
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@PreviewScreenSizes
@Composable
private fun PreviewDashboardScreen() {
    val dummyTopics = List(size = 20) { index ->
        QuizTopic(
            id = "1",
            name = "Android $index",
            imageUrl = "",
            code = 0
        )
    }
    val state = DashboardState(
        questionAttempted = 10,
        correctAnswers = 7,
        quizTopics = dummyTopics,
        isLoading = false,
        isNameEditDialogOpen = true
    )
    DashboardScreen(
        state = state
    )
}