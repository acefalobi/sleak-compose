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
    var trackNo: Int

    /**
     * Title of the song.
     */
    var title: String

    /**
     * The album the song appeared on.
     * Represented as a map of the id [Map.keys] to the album name [Map.values].
     * Will be null if the song isn't on an album, i.e a single.
     */
    var album: Map<String, String>?

    /**
     * The list of artists who made the song.
     * Represented as a map of the id [Map.keys] to the artist name [Map.values].
     */
    var artists: List<Map<String, String>>

    /**
     * The artist who owns the song.
     * Represented as a map of the id [Map.keys] to the artist name [Map.values].
     */
    var owner: Map<String, String>

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