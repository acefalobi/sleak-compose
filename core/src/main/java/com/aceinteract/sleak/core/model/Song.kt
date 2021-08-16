package com.aceinteract.sleak.core.model

import com.aceinteract.sleak.core.base.model.ISong

data class Song(
    override val id: String,
    override var trackPosition: Int,
    override var title: String,
    override var album: Pair<String, String>?,
    override var artists: Map<String, String>,
    override var owner: Pair<String, String>,
    override var year: Int,
    override var duration: Long,
    override var trackURI: String,
    override var coverUrl: String
) : ISong {
    /**
     * Converts duration in milliseconds to full text format.
     */
    fun getLengthInMinutes(): String {
        val inSeconds = duration / 1000.0
        val minutes = (inSeconds / 60.0).toInt()
        val seconds = (inSeconds % 60).toInt()
        return "$minutes:${seconds.toString().padStart(2, '0')}"
    }
}