package com.aceinteract.sleak.core.base.model

/**
 * Base interface for feed collection models (recommendations, trending).
 */
interface IFeedCollection {
    /**
     * The unique id of the feed collection.
     */
    val id: String

    /**
     * The name of the feed collection.
     */
    val name: String

    /**
     * The list of media items in this collection.
     */
    val mediaCollection: List<IMediaItem>
}