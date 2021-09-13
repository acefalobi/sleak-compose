package com.aceinteract.sleak.core.model

import com.aceinteract.sleak.core.base.model.IAlbum

data class Album(
    override var creator: Pair<String, String>,
    override var description: String,
    override val id: String,
    override var name: String,
    override var year: Int,
    override var mediaArtUrl: String,
    override val hexColor: String,
) : IAlbum