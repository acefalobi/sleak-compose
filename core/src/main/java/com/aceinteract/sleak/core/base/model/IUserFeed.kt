package com.aceinteract.sleak.core.base.model

/**
 * Base interface for a user's feed.
 */
interface IUserFeed {
    /**
     * The last episode the user listened to.
     *
     * Will be null if the user has never listened to a podcast episode.
     */
    val lastListenedEpisode: IEpisode?

    /**
     * The list of featured podcasts.
     */
    val featuredPodcasts: List<IPodcast>
}