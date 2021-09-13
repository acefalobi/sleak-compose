package com.aceinteract.sleak.ui.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aceinteract.sleak.common.ui.UiState
import com.aceinteract.sleak.common.util.Data
import com.aceinteract.sleak.common.util.runOnIO
import com.aceinteract.sleak.core.model.FeedCollection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow<FeedState>(FeedState.FetchingFeed)
    val uiState: StateFlow<FeedState> = _uiState

    private val _feedState: MutableStateFlow<UiState<List<FeedCollection>>> =
        MutableStateFlow(UiState.Loading())
    val feedState = _feedState

    init {
        loadFeed()
    }

    fun loadFeed() {
        _feedState.value = UiState.Loading()
        viewModelScope.runOnIO({
            delay(2000)
            _feedState.value = UiState.Success(Data.feed)
        }, {
            _feedState.value = UiState.Error(it)
        })
    }

}