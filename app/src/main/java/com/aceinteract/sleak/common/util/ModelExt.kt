package com.aceinteract.sleak.common.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.aceinteract.sleak.R
import com.aceinteract.sleak.core.base.model.IMediaItem
import com.aceinteract.sleak.core.model.Album
import com.aceinteract.sleak.core.model.Artist
import com.aceinteract.sleak.core.model.Playlist
import com.aceinteract.sleak.core.model.Song


val IMediaItem.type
    @Composable get() = when (this) {
        is Artist -> stringResource(id = R.string.artist)
        is Album -> stringResource(id = R.string.album)
        is Song -> stringResource(id = R.string.song)
        is Playlist -> stringResource(id = R.string.playlist)
        else -> ""
    }