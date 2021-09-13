package com.aceinteract.sleak.common.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.aceinteract.sleak.common.util.Data
import com.aceinteract.sleak.ui.theme.SleakTheme

@Composable
fun WaveFormSeeker(
    waveForm: List<Double>,
    color: Color = MaterialTheme.colors.primary,
    height: Dp = 80.dp,
    progress: Float = .5F
) {
    Row(
        Modifier
            .height(height)
            .fillMaxWidth()) {
        (0 until (waveForm.size * 2) - 1).forEach {
            val amplitude = waveForm[it / 2]
            val backgroundColor = if (it % 2 == 0) color else Color.Transparent
            val boxHeight = (amplitude / 100F) * height.value
            val opacity = if (it / 2 <= waveForm.size * progress) 1F else .1F
            val weight = if (it % 2 == 0) .7F else 1F
            Box(
                modifier = Modifier
                    .alpha(opacity)
                    .height(boxHeight.dp)
                    .weight(weight)
                    .align(Alignment.CenterVertically)
                    .background(color = backgroundColor, shape = MaterialTheme.shapes.medium)
                    .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}

@Preview
@Composable
fun WaveFormSeekerPreview() {
    SleakTheme {
        WaveFormSeeker(Data.sample)
    }
}