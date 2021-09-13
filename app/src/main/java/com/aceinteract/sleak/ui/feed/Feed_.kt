package com.aceinteract.sleak.ui.feed

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.aceinteract.sleak.R
import com.aceinteract.sleak.common.ui.UiState
import com.aceinteract.sleak.common.util.Data
import com.aceinteract.sleak.common.util.type
import com.aceinteract.sleak.core.base.model.IMediaItem
import com.aceinteract.sleak.core.base.model.IProject
import com.aceinteract.sleak.core.model.FeedCollection
import com.aceinteract.sleak.core.model.Playlist
import com.aceinteract.sleak.ui.theme.SleakTheme
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer
import kotlinx.coroutines.launch
import android.graphics.Color as AndroidColor

@Composable
fun FeedScreen(
    scaffoldState: ScaffoldState,
    modifier: Modifier = Modifier,
    uiState: UiState<List<FeedCollection>> = UiState.Loading(),
    playingSongColor: Color = MaterialTheme.colors.primary,
) {
    val scope = rememberCoroutineScope()
    Box(
        modifier = modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
            .background(MaterialTheme.colors.surface)
    ) {
        Column {
            Text(
                text = stringResource(R.string.home),
                modifier = Modifier.padding(16.dp, 24.dp, 16.dp, 10.dp),
                style = MaterialTheme.typography.h1
            )

            if (uiState is UiState.Error) {
                val errorMessage =
                    uiState.error.localizedMessage ?: stringResource(R.string.error_generic)
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(errorMessage)
                }
            }

            if (uiState is UiState.Success) {
                val feed = uiState.data
                feed.forEachIndexed { index, feedCollection ->
                    if (index == 0 && feedCollection.name.equals("trending", true)) {
                        val playlists = feedCollection.mediaCollection.map { it as Playlist }
                        TrendingRow(modifier = modifier, playlists = playlists) {
                            scope.launch {
                                scaffoldState.snackbarHostState.showSnackbar(
                                    "Selected playlist: ${it.name}"
                                )
                            }
                        }
                    } else {
                        FeedRow(
                            modifier = modifier,
                            collection = feedCollection,
                            playingSongColor = playingSongColor,
                            onSeeAllClick = {
                                scope.launch {
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        "Selected ${it.name} from feed"
                                    )
                                }
                            },
                            onCardClick = {
                                scope.launch {
                                    val type = it::class.simpleName
                                    scaffoldState.snackbarHostState.showSnackbar(
                                        "Selected $type: ${it.name}"
                                    )
                                }
                            }
                        )
                    }
                }
            } else {
                LazyRow(modifier = modifier, contentPadding = PaddingValues(8F.dp)) {
                    items(2) {
                        TrendingCard(
                            Playlist.placeHolderObject,
                            Modifier.padding(8F.dp, 0.dp),
                            true
                        )
                    }
                }
                listOf(
                    FeedCollection.placeHolderObject,
                    FeedCollection.placeHolderObject,
                    FeedCollection.placeHolderObject
                ).forEach {
                    FeedRow(
                        modifier = modifier,
                        collection = it,
                        playingSongColor = playingSongColor,
                        isPlaceHolder = true
                    )
                }
            }
        }
    }
}

@Composable
fun TrendingRow(modifier: Modifier, playlists: List<Playlist>, onCardClick: (Playlist) -> Unit) {
    LazyRow(modifier = modifier, contentPadding = PaddingValues(8F.dp)) {
        playlists.forEach { media ->
            item {
                TrendingCard(media, Modifier.padding(8F.dp, 0.dp), onCardClick = onCardClick)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TrendingCard(
    playlist: Playlist,
    modifier: Modifier = Modifier,
    isPlaceHolder: Boolean = false,
    onCardClick: (Playlist) -> Unit = {},
) {
    Card(
        onClick = { onCardClick(playlist) },
        modifier = modifier
            .height(160F.dp)
            .width(320F.dp)
            .placeholder(visible = isPlaceHolder, highlight = PlaceholderHighlight.shimmer()),
        elevation = 6F.dp
    ) {
        Image(
            painter = rememberImagePainter(
                data = playlist.mediaArtUrl,
                builder = {
                    scale(Scale.FILL)
                    placeholder(ColorDrawable(AndroidColor.parseColor(playlist.hexColor)))
                    crossfade(true)
                }
            ),
            contentDescription = playlist.name,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Column(Modifier.padding(12F.dp, 12.dp), Arrangement.Bottom) {
            Text(text = playlist.name, style = MaterialTheme.typography.h5)

            Spacer(modifier = Modifier.height(1F.dp))

            Text(
                text = playlist.description,
                modifier = Modifier.alpha(.6F),
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}

@Composable
fun FeedRow(
    modifier: Modifier,
    collection: FeedCollection,
    playingSongColor: Color,
    onSeeAllClick: (FeedCollection) -> Unit = {},
    onCardClick: (IMediaItem) -> Unit = {},
    isPlaceHolder: Boolean = false,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp, 16.dp)
    ) {
        Text(
            text = collection.name.toUpperCase(Locale.current),
            modifier = Modifier
                .alpha(if (isPlaceHolder) 1F else .4F)
                .align(Alignment.CenterStart)
                .placeholder(visible = isPlaceHolder, highlight = PlaceholderHighlight.shimmer()),
            style = MaterialTheme.typography.h5,
            letterSpacing = 1F.sp
        )

        TextButton(
            onClick = { onSeeAllClick(collection) },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .placeholder(visible = isPlaceHolder, highlight = PlaceholderHighlight.shimmer())
        ) {
            Text(
                text = stringResource(id = R.string.see_all).toUpperCase(Locale.current),
                color = playingSongColor
            )
        }
    }
    LazyRow(modifier = modifier, contentPadding = PaddingValues(8F.dp)) {
        collection.mediaCollection.forEach { media ->
            item {
                MediaCard(
                    media,
                    Modifier.padding(8F.dp, 0.dp),
                    isPlaceHolder = isPlaceHolder,
                    onCardClick = onCardClick
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MediaCard(
    media: IMediaItem,
    modifier: Modifier = Modifier,
    isPlaceHolder: Boolean = false,
    onCardClick: (IMediaItem) -> Unit = {},
) {
    Column(
        modifier
            .width(120F.dp)
    ) {
        Card(
            onClick = { onCardClick(media) },
            modifier = Modifier
                .height(120F.dp)
                .fillMaxWidth()
                .placeholder(visible = isPlaceHolder, highlight = PlaceholderHighlight.shimmer()),
            elevation = 6F.dp
        ) {
            Image(
                painter = rememberImagePainter(
                    data = media.mediaArtUrl,
                    builder = {
                        scale(Scale.FILL)
                        placeholder(ColorDrawable(AndroidColor.parseColor(media.hexColor)))
                        crossfade(true)
                    }
                ),
                contentDescription = media.name,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = media.name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.placeholder(
                visible = isPlaceHolder,
                highlight = PlaceholderHighlight.shimmer()
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = if (media !is IProject || media is Playlist) media.type else media.creator.second,
            modifier = Modifier
                .alpha(if (isPlaceHolder) 1F else .6F)
                .placeholder(
                    visible = isPlaceHolder,
                    highlight = PlaceholderHighlight.shimmer()
                ),
            style = MaterialTheme.typography.subtitle2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun TrendingCardPreview() {
    SleakTheme {
        FeedScreen(rememberScaffoldState(), uiState = UiState.Success(Data.feed))
    }
}