package com.example.quiztime_android.presentation.dashboard

data class DashboardState(
    val userName: String = "Android Developer",
    val questionAttempted: Int = 0,
    val correctAnswers: Int = 0,
)
