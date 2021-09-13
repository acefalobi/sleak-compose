package com.aceinteract.sleak.core.model

import com.aceinteract.sleak.core.base.model.IFeedCollection
import com.aceinteract.sleak.core.base.model.IMediaItem

data class FeedCollection(
    override val id: String,
    override val name: String,
    override val mediaCollection: List<IMediaItem>,
) : IFeedCollection {
    companion object {
        private val mediaItemPlaceHolder = object : IMediaItem {
            override val id: String = "x"
            override val name: String = "xxxxxxxxxxx"
            override val description: String = ""
            override val mediaArtUrl: String = ""
            override val hexColor: String = "#FFFFFF"
        }
        val placeHolderObject = FeedCollection(
            "x",
            "xxxxxxxxxxxxxxxxx",
            listOf(
                mediaItemPlaceHolder,
                mediaItemPlaceHolder,
                mediaItemPlaceHolder,
                mediaItemPlaceHolder
            )
        )
    }
}