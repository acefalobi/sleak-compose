package com.aceinteract.sleak.core.model

import com.aceinteract.sleak.core.base.model.IArtist

data class Artist(
    override var description: String,
    override val id: String,
    override var name: String,
    override var mediaArtUrl: String,
    override val hexColor: String,
) : IArtist {

    companion object {
        val placeHolderObject = Artist(
            "xxxxxxxx xx xxx xxxx",
            "0",
            "xxxxxx xxxxxxxx",
            "",
            "#FFFFFF"
        )
    }

}