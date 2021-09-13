package com.aceinteract.sleak.core.base.model

/**
 * Base interface for media item models (Projects, Artists).
 */
interface IMediaItem {
    /**
     * The unique id of the media item.
     */
    val id: String

    /**
     * The title (or title) of the media item.
     */
    val name: String

    /**
     * The description of the media item.
     */
    val description: String

    /**
     * The url of the media item's art (Profile Picture, Album Cover, Playlist Cover)
     */
    val mediaArtUrl: String

    /**
     * The HEX color of the media item.
     * It's usually based off the media art.
     */
    val hexColor: String
}