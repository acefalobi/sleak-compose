package com.aceinteract.sleak.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.aceinteract.sleak.R
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Box(modifier.statusBarsPadding()) {
        Text(stringResource(R.string.profile))
    }
}