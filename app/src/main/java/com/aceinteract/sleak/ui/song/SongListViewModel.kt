package com.aceinteract.sleak.ui.song

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aceinteract.sleak.common.ui.UiState
import com.aceinteract.sleak.common.util.Data
import com.aceinteract.sleak.common.util.runOnIO
import com.aceinteract.sleak.core.model.Song
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SongListViewModel @Inject constructor() : ViewModel() {

    private val _songsState: MutableStateFlow<UiState<List<Song>>> = MutableStateFlow(UiState.Loading())
    val songsState = _songsState

    init {
        loadSongs()
    }

    fun loadSongs() {
        _songsState.value = UiState.Loading()
        viewModelScope.runOnIO({
            delay(2000)
            _songsState.value = UiState.Success(Data.songs)
        }, {
            _songsState.value = UiState.Error(it)
        })
    }

}