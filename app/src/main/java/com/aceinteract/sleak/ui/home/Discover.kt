package com.aceinteract.sleak.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.aceinteract.sleak.R
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun DiscoverScreen(modifier: Modifier = Modifier) {
    Box(modifier.statusBarsPadding()) {
        Text(stringResource(R.string.discover))
    }
}