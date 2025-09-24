package com.example.quiztime_android.presentation.quiz

import com.example.quiztime_android.domain.model.QuizQuestion
import com.example.quiztime_android.domain.model.UserAnswer

data class QuizState(
    val questions: List<QuizQuestion> = emptyList(),
    val answers: List<UserAnswer> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val errorMessage: String? = null,
    val isSubmitQuizDialogOpen: Boolean = false,
    val isExitQuizDialogOpen: Boolean = false,
    val isLoading: Boolean = false,
    val loadingMessage: String? = null,
    val topBarTitle: String = "Quiz"
)
