package com.aceinteract.sleak.core.model

import com.aceinteract.sleak.core.base.model.IPlaylist

data class Playlist(
    override var creator: Pair<String, String>,
    override var description: String,
    override val id: String,
    override var name: String,
    override var year: Int,
    override var mediaArtUrl: String,
    override val hexColor: String,
) : IPlaylist {

    companion object {
        val placeHolderObject = Playlist(
            "0" to "xxxxx",
            "xxxxxxxx xx xxx xxxx",
            "0",
            "xxxxxx xxxxxxxx",
            0,
            "",
            "#FFFFFF"
        )
    }

}