package com.example.quiztime_android.presentation.issue_report

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.quiztime_android.presentation.issue_report.component.IssueReportScreenTopBar
import com.example.quiztime_android.presentation.issue_report.component.QuestionCard

@Composable
fun IssueReportScreen(
    state: IssueReportState
) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        IssueReportScreenTopBar(
            title = "Report an Issue",
            onBackButtonClick = {}
        )
        QuestionCard(
            modifier = Modifier.fillMaxWidth(),
            question = state.quizQuestion,
            isCardExpanded = state.isQuestionCardExpanded,
            onExpandClick = {}
        )
    }
}