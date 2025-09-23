package com.example.quiztime_android.presentation.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiztime_android.domain.model.QuizQuestions
import com.example.quiztime_android.domain.model.UserAnswer
import com.example.quiztime_android.presentation.quiz.component.QuizScreenTopBar

@Composable
fun QuizScreen(
    state: QuizState
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        QuizScreenTopBar(
            title = "Android Quiz",
            onExitQuizButtonClick = {}
        )
        QuestionNavigationRow(
            currentQuestionIndex = 2,
            questions = state.questions,
            answers = state.answers,
            onTabSelected = {}
        )
    }
}

@Composable
private fun QuestionNavigationRow(
    modifier: Modifier = Modifier,
    currentQuestionIndex: Int,
    questions: List<QuizQuestions>,
    answers: List<UserAnswer>,
    onTabSelected: (Int) -> Unit
) {
    ScrollableTabRow(
        modifier = modifier,
        selectedTabIndex = currentQuestionIndex,
        edgePadding = 0.dp
    ) {
        questions.forEachIndexed { index, question ->
            val containerColor = when {
                answers.any { it.questionId == question.id } -> {
                    MaterialTheme.colorScheme.secondaryContainer
                }
                else -> MaterialTheme.colorScheme.surface
            }
            Tab(
                modifier = Modifier.background(containerColor),
                selected = currentQuestionIndex == index,
                onClick = {onTabSelected(index)}
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = "${index + 1}"
                )
            }
        }
    }
}

@Composable
fun QuestionItem(
    modifier: Modifier = Modifier
) {
    
}

@Preview(showBackground = true)
@Composable
private fun PreviewQuizScreen() {
    val dummyQuestions = List(size = 10) { index ->
        QuizQuestions(
            id = "$index",
            topicCode = 1,
            question = "What is the language for Android Dev?",
            allOptions = listOf("Java", "Python", "Dart", "Kotlin"),
            correctAnswer = "Kotlin",
            explanation = "Some Explanation"
        )
    }
    val dummyAnswers = listOf(
        UserAnswer(questionId = "1", selectedOption = ""),
        UserAnswer(questionId = "3", selectedOption = "")
    )
    QuizScreen(
        state = QuizState(questions = dummyQuestions, answers = dummyAnswers)
    )
}