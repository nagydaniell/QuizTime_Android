package com.example.quiztime_android.presentation.quiz

import com.example.quiztime_android.domain.model.QuizQuestions
import com.example.quiztime_android.domain.model.UserAnswer

data class QuizState(
    val questions: List<QuizQuestions> = emptyList(),
    val answers: List<UserAnswer> = emptyList(),
    val currentQuestionIndex: Int = 0,
    val errorMessage: String? = null,
    val topBarTitle: String = "Quiz"
)
