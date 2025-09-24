package com.example.quiztime_android.presentation.result

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztime_android.R
import com.example.quiztime_android.domain.model.QuizQuestion
import com.example.quiztime_android.domain.model.UserAnswer
import com.example.quiztime_android.presentation.theme.CustomGreen

@Composable
fun ResultScreen(
    state: ResultState
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn (
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(10.dp)
        ) {
            item {
                ScoreCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 80.dp, horizontal = 10.dp),
                    scorePercentage = state.scorePercentage,
                    correctAnswerCount = state.correctAnswerCount,
                    totalQuestions = state.totalQuestions
                )
            }
            item {
                Text(
                    text = "Quiz Questions",
                    style = MaterialTheme.typography.titleLarge,
                    textDecoration = TextDecoration.Underline
                )
            }
            items(state.quizQuestions) { question ->
                val userAnswer = state.usersAnswer
                    .find { it.questionId == question.id }?.selectedOption
                QuestionItem(
                    question = question,
                    userSelectedAnswer = userAnswer,
                    onReportIconClick = {}
                )
            }
        }
        Button(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            onClick = {}
        ) {
            Text(
                text = "Start New Quiz"
            )
        }
    }
}

@Composable
private fun ScoreCard(
    modifier: Modifier = Modifier,
    scorePercentage: Int,
    correctAnswerCount: Int,
    totalQuestions: Int
) {
    val resultText = when(scorePercentage) {
        in 71 .. 100 -> "Congratulations!\nGreat performance!"
        in 41 .. 70 -> "You did well,\nbut there's room for improvement"
        else -> "You may have struggled this time,\nMistakes are part of learning, keep going!"
    }
    val resultIconResId = when(scorePercentage) {
        in 71 .. 100 -> R.drawable.ic_laugh
        in 41 .. 70 -> R.drawable.ic_smile
        else -> R.drawable.ic_sad
    }
    Card (
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)
                .size(100.dp),
            painter = painterResource(resultIconResId),
            contentDescription = null
        )
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "You answered correctly $correctAnswerCount out of $totalQuestions.",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            text = resultText,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun QuestionItem(
    modifier: Modifier = Modifier,
    question: QuizQuestion,
    userSelectedAnswer: String?,
    onReportIconClick: () -> Unit
) {
    Column (
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Q: ${question.question}",
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = onReportIconClick) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "Report"
                )
            }
        }
        question.allOptions.forEachIndexed {index, option -> // previously it was forEach with only option
            val letter = when(index) {
                0 -> "(a)"
                1 -> "(a)"
                2 -> "(a)"
                3 -> "(a)"
                else -> ""
            }
            val optionColor = when (option) {
                question.correctAnswer -> CustomGreen
                userSelectedAnswer -> MaterialTheme.colorScheme.error
                else -> LocalContentColor.current
            }
            Text(
                text = letter + option,
                color = optionColor
            )
        }
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = question.explanation,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
        )
        HorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewResultScreen() {
    val dummyQuestions = List(size = 10) { index ->
        QuizQuestion(
            id = "$index",
            topicCode = 1,
            question = "What is the language for Android Dev?",
            allOptions = listOf("Java", "Python", "Dart", "Kotlin"),
            correctAnswer = "Kotlin",
            explanation = "Some Explanation"
        )
    }
    val dummyAnswers = listOf(
        UserAnswer(questionId = "1", selectedOption = "Python"),
        UserAnswer(questionId = "0", selectedOption = "Kotlin")
    )
    ResultScreen(
        state = ResultState(
            scorePercentage = 20,
            correctAnswerCount = 7,
            totalQuestions = 10,
            quizQuestions = dummyQuestions,
            usersAnswer = dummyAnswers
        )
    )
}