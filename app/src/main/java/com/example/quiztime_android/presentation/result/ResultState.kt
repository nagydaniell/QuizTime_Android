package com.example.quiztime_android.presentation.result

import com.example.quiztime_android.domain.model.QuizQuestion
import com.example.quiztime_android.domain.model.UserAnswer

data class ResultState(
    val scorePercentage: Int = 0,
    val correctAnswerCount: Int = 0,
    val totalQuestions: Int = 0,
    val quizQuestions: List<QuizQuestion> = emptyList(),
    val usersAnswer: List<UserAnswer> = emptyList()
)
