package com.aceinteract.sleak.core.base.model

/**
 * Base interface for song models.
 */
interface ISong : IProject {
    /**
     * Track position on an album.
     */
    var trackPosition: Int

    /**
     * The album the song appeared on.
     * Represented as a map of the id [Pair.first] to the album title [Pair.second].
     * Will be null if the song isn't on an album, i.e a single.
     */
    var album: Pair<String, String>?

    /**
     * The list of artists who made the song.
     * Represented as a map of the id [Map.keys] to the artist title [Map.values].
     */
    var artists: Map<String, String>

    /**
     * The duration of the song in milliseconds.
     */
    var duration: Long

    /**
     * The URL used to access the song.
     */
    var trackURI: String
}