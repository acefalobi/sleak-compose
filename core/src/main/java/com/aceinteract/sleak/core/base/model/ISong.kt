package com.aceinteract.sleak.core.base.model

/**
 * Base interface for song models.
 */
interface ISong {
    /**
     * The unique id of the song.
     */
    val id: String

    /**
     * Track position on an album.
     */
    var trackPosition: Int

    /**
     * Title of the song.
     */
    var title: String

    /**
     * The album the song appeared on.
     * Represented as a map of the id [Pair.first] to the album name [Pair.second].
     * Will be null if the song isn't on an album, i.e a single.
     */
    var album: Pair<String, String>?

    /**
     * The list of artists who made the song.
     * Represented as a map of the id [Map.keys] to the artist name [Map.values].
     */
    var artists: Map<String, String>

    /**
     * The artist who owns the song.
     * Represented as a map of the id [Pair.first] to the artist name [Pair.second].
     */
    var owner: Pair<String, String>

    /**
     * The year the song was released.
     */
    var year: Int

    /**
     * The duration of the song in milliseconds.
     */
    var duration: Long

    /**
     * The URL used to access the song.
     */
    var trackURI: String

    /**
     * The url of the song cover art.
     */
    var coverUrl: String
}