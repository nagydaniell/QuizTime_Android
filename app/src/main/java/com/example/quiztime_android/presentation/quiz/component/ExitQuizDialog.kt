package com.example.quiztime_android.presentation.quiz.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ExitQuizDialog(
    modifier: Modifier = Modifier,
    isOpen: Boolean, // see this Dialog if we open it
    title: String = "Exit Quiz",
    confirmButtonText: String = "Exit",
    dismissButtonText: String = "No",
    onDialogDismiss: () -> Unit,
    onConfirmButtonClick: () -> Unit
) {
    if (isOpen){
        AlertDialog(
            modifier = modifier,
            title = { Text(text = title) },
            text = {
                Text(text = "Are you sure, you want to exit the quiz?" +
                        "You won't be able to continue from where you left off.")
            },
            onDismissRequest = onDialogDismiss,
            confirmButton = {
                TextButton(
                    onClick = onConfirmButtonClick) {
                    Text(text = confirmButtonText)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDialogDismiss) { // dismiss the dialog, if cancel or outside of the box
                    Text(text = dismissButtonText)
                }
            },
        )
    }
}

@Preview
@Composable
private fun ExitQuizDialog() {
    ExitQuizDialog(
        isOpen = true,
        onDialogDismiss = {},
        onConfirmButtonClick = {},
    )
}