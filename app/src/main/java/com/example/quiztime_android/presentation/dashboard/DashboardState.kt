package com.example.quiztime_android.presentation.dashboard

import com.example.quiztime_android.domain.model.QuizTopic

data class DashboardState(
    val userName: String = "Android Developer",
    val questionAttempted: Int = 0,
    val correctAnswers: Int = 0,
    val quizTopics: List<QuizTopic> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isNameEditDialogOpen: Boolean = false,
    val usernameTextFieldValue: String = "",
    val usernameError: String? = null
)
