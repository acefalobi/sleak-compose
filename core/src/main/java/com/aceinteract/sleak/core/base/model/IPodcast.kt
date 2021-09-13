package com.aceinteract.sleak.core.base.model

/**
 * Base interface for a podcast.
 */
interface IPodcast {
    /**
     * The unique id of the podcast.
     */
    val id: String

    /**
     * The title of the podcast.
     */
    val title: String

    /**
     * The description of the podcast.
     */
    val description: String

    /**
     * The url of the podcast's cover image.
     */
    val coverUrl: String

    /**
     * The author who created the podcast.
     * Represented as a map of the id [Pair.first] to the user's title [Pair.second].
     */
    val author: Pair<String, String>

    /**
     * The no of users following this podcast.
     */
    val noOfFollowers: Int

    /**
     * Whether or not the user is following this podcast.
     */
    val isUserFollowing: Boolean

    /**
     * The HEX color of the podcast.
     */
    val hexColor: String
}