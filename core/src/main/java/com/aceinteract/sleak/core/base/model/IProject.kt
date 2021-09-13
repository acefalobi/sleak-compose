package com.aceinteract.sleak.core.base.model

/**
 * Base interface for project models (Playlists, Songs, Albums).
 */
interface IProject: IMediaItem {
    /**
     * The year the project was released.
     */
    var year: Int

    /**
     * The user or artist who created the collection.
     * Represented as a map of the id [Pair.first] to the user's title [Pair.second].
     */
    val creator: Pair<String, String>
}