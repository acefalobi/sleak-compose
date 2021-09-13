package com.aceinteract.sleak.core.model

import com.aceinteract.sleak.core.base.model.IUserFeed

data class UserFeed(
    override val lastListenedEpisode: Episode?,
    override val featuredPodcasts: List<Podcast>
) : IUserFeed