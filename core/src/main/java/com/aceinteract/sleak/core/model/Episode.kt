package com.aceinteract.sleak.core.model

import com.aceinteract.sleak.core.base.model.IEpisode
import java.util.Date

data class Episode(
    override val id: String,
    override var podcast: Pair<String, String>,
    override val title: String,
    override val description: String,
    override val coverUrl: String,
    override var releaseDate: Date,
    override var position: Int,
    override var duration: Long,
    override var trackURI: String,
    override var waveForm: List<Int>,
    override val hexColor: String
) : IEpisode