package com.example.quiztime_android.domain.model

data class QuizQuestion(
    val id: String,
    val topicCode: Int,
    val question: String,
    val allOptions: List<String>,
    val correctAnswer: String,
    val explanation: String
)
