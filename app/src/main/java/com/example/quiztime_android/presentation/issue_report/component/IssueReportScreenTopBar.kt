package com.example.quiztime_android.presentation.issue_report.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.quiztime_android.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IssueReportScreenTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onBackButtonClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Navigate back"
                )
            }
        }
    )
}

@Preview
@Composable
private fun PreviewIssueReportScreenTopBar() {
    IssueReportScreenTopBar(
        title = "Report an Issue",
        onBackButtonClick = {}
    )
}