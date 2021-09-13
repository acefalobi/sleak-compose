package com.aceinteract.sleak.core.model

import com.aceinteract.sleak.core.base.model.IPodcast

data class Podcast(
    override val id: String,
    override val title: String,
    override val description: String,
    override val coverUrl: String,
    override val author: Pair<String, String>,
    override val noOfFollowers: Int,
    override val isUserFollowing: Boolean,
    override val hexColor: String
) : IPodcast