package com.aceinteract.sleak.ui.home

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.aceinteract.sleak.ui.feed.FeedScreen
import com.aceinteract.sleak.ui.feed.FeedViewModel


enum class Page(val route: String) {
    /**
     * Root routes.
     */
    HOME("home"),

    /**
     * Main Routes.
     */
    FEED("home/feed"),
    DISCOVER("home/discover"),
    LIBRARY("home/library")
}

@Composable
fun SleakNavGraph(
    scaffoldState: ScaffoldState,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Page.HOME.route,
) {
    NavHost(navController, startDestination, modifier) {
        navigation(Page.FEED.route, Page.HOME.route) {
            homeGraph(scaffoldState)
        }
    }
}

fun NavGraphBuilder.homeGraph(scaffoldState: ScaffoldState, modifier: Modifier = Modifier) {
    composable(Page.FEED.route) {
        val viewModel = hiltViewModel<FeedViewModel>()
        val uiState by viewModel.feedState.collectAsState()
        FeedScreen(scaffoldState, modifier, uiState)
    }
    composable(Page.DISCOVER.route) {
        DiscoverScreen(modifier)
    }
    composable(Page.LIBRARY.route) {
        LibraryScreen(modifier)
    }
}