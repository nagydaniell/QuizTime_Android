package com.example.quiztime_android.presentation.issue_report

import com.example.quiztime_android.domain.model.QuizQuestion

data class IssueReportState(
    val quizQuestion: QuizQuestion? = null,
    val isQuestionCardExpanded: Boolean = false
)