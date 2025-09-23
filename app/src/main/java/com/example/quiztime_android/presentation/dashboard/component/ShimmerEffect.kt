package com.example.quiztime_android.presentation.dashboard.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerEffect(
    modifier: Modifier = Modifier,
    shimmerColor: Color = MaterialTheme.colorScheme.surface
) {

    // list of colours for gradient
    val shimmerColors = listOf(
        shimmerColor.copy(alpha = 0.6f),
        shimmerColor.copy(alpha = 0.2f),
        shimmerColor.copy(alpha = 0.6f),
    )
    val transition = rememberInfiniteTransition(label = "")
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000), // 1 sec to animate from 0 to 1000
            repeatMode = RepeatMode.Restart
        ),
        label = "Shimmer Loading animation"
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )

    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(brush)
        )
    }
}

@Preview
@Composable
private fun PreviewShimmerEffect() {
    ShimmerEffect(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    )
}