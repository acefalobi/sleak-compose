package com.aceinteract.sleak.ui.song

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aceinteract.sleak.common.ui.UiState
import com.aceinteract.sleak.common.util.Data
import com.aceinteract.sleak.core.model.Song
import com.aceinteract.sleak.ui.theme.SleakTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Preview(showBackground = true)
@Composable
fun SongListPreview() {
    SleakTheme {
        SongList(UiState.Success(Data.songs)) {

        }
    }
}

@Composable
fun SongListScreen(viewModel: SongListViewModel, scaffoldState: ScaffoldState) {
    val uiState by viewModel.songsState.collectAsState()
    SongList(uiState) {
        viewModel.loadSongs()
    }
    if (uiState is UiState.Error) {
        LaunchedEffect("error") {
            scaffoldState.snackbarHostState.showSnackbar((uiState as UiState.Error<List<Song>>).error.localizedMessage
                ?: "An error occurred")
        }
    }
}

@Composable
fun SongList(uiState: UiState<List<Song>>, onRefresh: () -> Unit) {
    val swipeRefreshState = rememberSwipeRefreshState(uiState is UiState.Success)
    SwipeRefresh(swipeRefreshState, onRefresh, Modifier.height(IntrinsicSize.Max)) {
        val songs = if (uiState is UiState.Success) uiState.data else emptyList()
        LazyColumn {
            items(songs, { song -> song.id }) {
                SongItem(it)
            }
        }
    }
}

@Composable
fun SongItem(song: Song) {
    Text("${song.title} by ${song.owner.second}")
}