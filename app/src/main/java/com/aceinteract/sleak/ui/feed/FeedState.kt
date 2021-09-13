package com.aceinteract.sleak.ui.feed

import com.aceinteract.sleak.core.model.UserFeed

/**
 * State management for the home feed.
 */
sealed interface FeedState {

    data class FetchedFeed(val feed: UserFeed) : FeedState

    object FetchingFeed : FeedState

    data class Error(val error: Throwable) : FeedState
}