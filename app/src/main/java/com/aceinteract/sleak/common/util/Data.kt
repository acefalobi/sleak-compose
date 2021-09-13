package com.aceinteract.sleak.common.util

import com.aceinteract.sleak.core.model.Album
import com.aceinteract.sleak.core.model.Artist
import com.aceinteract.sleak.core.model.Episode
import com.aceinteract.sleak.core.model.FeedCollection
import com.aceinteract.sleak.core.model.Playlist
import com.aceinteract.sleak.core.model.Song
import com.aceinteract.sleak.core.model.UserFeed
import java.util.Date
import kotlin.random.Random

object Data {
    val songs = listOf(
        Song(
            "0",
            0,
            "Lay With Ya (feat. Duke Deuce)",
            "0" to "The House Is Burning",
            mapOf("0" to "Isaiah Rashad", "1" to "Duke Deuce"),
            "0" to "Isaiah Rashad",
            2021,
            202000L,
            "abs",
            "https://media.pitchfork.com/photos/60e5d49e74f9548edb38cbe9/1:1/w_600/Isaiah-Rashad.jpg",
            "",
            "#D9B23D"
        ),
        Song(
            "1",
            0,
            "Body",
            "0" to "Good News",
            mapOf("0" to "Megan Thee Stallion"),
            "0" to "Megan Thee Stallion",
            2020,
            171000,
            "abs",
            "https://media.pitchfork.com/photos/5fb55b914cb304ce01ca1308/1:1/w_320/Good%20News_Megan%20Thee%20Stallion.jpg",
            "",
            "#A60F2B"
        ),
        Song(
            "2",
            0,
            "Little Deer",
            "0" to "The Turning Wheel",
            mapOf("0" to "Spellling"),
            "0" to "Spellling",
            2021,
            339000,
            "abs",
            "https://media.pitchfork.com/photos/6075ee30f892f2ea2aa06f5d/1:1/w_600/SPELLLING-The-Turning-Wheel.jpg",
            "",
            "#262526"
        )
    ).shuffled()

    val playlists = listOf(
        Playlist(
            "0" to "Sleak",
            "Trending in the week",
            "0",
            "What's trending",
            2021,
            "https://www.baltana.com/files/wallpapers-10/Blue-White-Abstract-Wallpaper-28535.jpg",
            "#044BD9"
        ),
        Playlist(
            "0" to "Sleak",
            "Top 15 in the last week",
            "1",
            "Weekly Top 15",
            2021,
            "https://www.baltana.com/files/wallpapers-10/White-Abstract-Art-Wallpaper-28552.jpg",
            "#3698BF"
        ),
        Playlist(
            "0" to "Sleak",
            "Most promising artists right now",
            "0",
            "Next Gen",
            2020,
            "https://i.pinimg.com/originals/5d/ab/4d/5dab4d5e50156cb929c1b1946085bdde.jpg",
            "#F279BC"
        )
    ).shuffled()

    val albums = listOf(
        Album(
            "0" to "Tyler, the Creator",
            "",
            "0",
            "Call Me If You Get Lost",
            2021,
            "https://media.pitchfork.com/photos/60cb72ddadc2201193add729/1:1/w_600/Tyler-the-Creator.jpg",
            "#D9CA7E"
        ),
        Album(
            "0" to "Japanese Breakfast",
            "",
            "0",
            "Jubilee",
            2021,
            "https://cdn2.albumoftheyear.org/250x/album/341271-jubilee.jpg",
            "#F2DEA2"
        ),
        Album(
            "0" to "Frank Ocean",
            "",
            "0",
            "Channel Orange",
            2021,
            "https://cdn2.albumoftheyear.org/250x/album/channel-orange-1.jpg",
            "#78A4BF"
        )
    ).shuffled()

    val artists = listOf(
        Artist(
            "Anti-hero",
            "0",
            "Genesis Owusu",
            "https://video-images.vice.com/articles/59f1642f13858c52b1bf32e2/lede/1508992051200-i-D-ash-55.jpeg?crop=1xw%3A0.8444xh%3B0xw%2C0.0543xh&resize=2000%3A*",
            "#F2D377"
        ),
        Artist(
            "Drum King",
            "0",
            "Anderson .Paak",
            "https://cdn.albumoftheyear.org/artists/sq/anderson-paak_1482471677.jpg",
            "#060D0A"
        ),
        Artist(
            "Pop Queen",
            "0",
            "Lorde",
            "https://cdn.albumoftheyear.org/artists/sq/lorde_1629379808.jpg",
            "#D9D7D8"
        )
    ).shuffled()

    val mediaCollection = (playlists + artists + albums + songs).shuffled()

    val feed = listOf(
        FeedCollection("0", "Trending", playlists.take(3)),
        FeedCollection("0", "Recently Played", mediaCollection.take(6)),
        FeedCollection("0", "Hot Right Now", mediaCollection.takeLast(6)),
        FeedCollection("0", "More like Fiona Apple", artists)
    )

    val feed_ = UserFeed(
        Episode(
            "0",
            "0" to "The Staircase",
            "Finding your path to uncommon success",
            "Being a personal brand entrepreneur means that you actually do not have any competitors something something lorem ipusm dolor emet",
            "https://cdn.albumoftheyear.org/artists/sq/lorde_1629379808.jpg",
            Date(),
            8,
            202000L,
            "",
            MutableList(50) { Random.nextInt(100) },
            "#D9D7D8"
        ),
        emptyList()
    )

    val sample = listOf(
        20.0, 81.84303, 82.2567, 77.460754, 71.87627, 67.00277, 66.36934, 68.554016, 73.194824, 65.82641, 76.11634, 90.0, 88.9012, 84.28624, 85.126495, 79.83934, 85.55309, 82.28255, 78.92151, 83.10988, 82.670364, 85.682365, 79.51616, 87.789474, 76.81441, 74.87535, 73.67313, 69.00646, 79.52908, 72.67775, 70.81625, 71.82456, 84.72576, 78.805176, 86.39335, 83.65282, 76.452446, 80.64081, 80.13666, 23.891043
    )
}