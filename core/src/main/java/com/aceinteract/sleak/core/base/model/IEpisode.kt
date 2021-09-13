package com.aceinteract.sleak.core.base.model

import java.util.Date

/**
 * Base interface for a podcast episode.
 */
interface IEpisode {
    /**
     * The unique id of the podcast episode.
     */
    val id: String

    /**
     * The podcast the episode appeared on.
     * Represented as a map of the id [Pair.first] to the podcast title [Pair.second].
     */
    var podcast: Pair<String, String>

    /**
     * The title of the episode.
     */
    val title: String

    /**
     * The description of the episode.
     */
    val description: String

    /**
     * The url of the podcast's cover image.
     */
    val coverUrl: String

    /**
     * The date the episode was released.
     */
    var releaseDate: Date

    /**
     * Episode position on a the podcast.
     */
    var position: Int

    /**
     * The duration of the episode in milliseconds.
     */
    var duration: Long

    /**
     * The URL used to access the episode.
     */
    var trackURI: String

    /**
     * The list of averaged and normalised samples of the track.
     */
    var waveForm: List<Int>

    /**
     * The HEX color of the podcast.
     */
    val hexColor: String
}