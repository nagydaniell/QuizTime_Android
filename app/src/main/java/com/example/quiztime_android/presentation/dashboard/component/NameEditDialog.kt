package com.example.quiztime_android.presentation.dashboard.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun NameEditDialog(
    modifier: Modifier = Modifier,
    isOpen: Boolean, // see this Dialog if we open it
    textFieldValue: String,
    userNameError: String?,
    title: String = "Edit your name",
    confirmButtonText: String = "Rename",
    dismissButtonText: String = "Cancel",
    onTextFieldValueChange: (String) -> Unit,
    onDialogDismiss: () -> Unit,
    onConfirmButtonClick: () -> Unit
) {
    if (isOpen){
        AlertDialog(
            modifier = modifier,
            title = { Text(text = title) },
            text = {
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = onTextFieldValueChange,
                    singleLine = true,
                    isError = userNameError != null && textFieldValue.isNotBlank(),
                    supportingText = { Text(text = userNameError.orEmpty()) }
                )
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
private fun PreviewNameEditDialog() {
    NameEditDialog(
        isOpen = true,
        textFieldValue = "a",
        userNameError = "Name is too long",
        onDialogDismiss = {},
        onConfirmButtonClick = {},
        onTextFieldValueChange = {}
    )
}