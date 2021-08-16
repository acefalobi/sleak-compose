package com.aceinteract.sleak.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.aceinteract.sleak.ui.profile.ProfileScreen


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
    LIBRARY("home/library"),
    PROFILE("home/profile")
}

@Composable
fun SleakNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Page.HOME.route,
) {
    NavHost(navController, startDestination, modifier) {
        navigation(Page.FEED.route, Page.HOME.route) {
            homeGraph()
        }
    }
}

fun NavGraphBuilder.homeGraph(modifier: Modifier = Modifier) {
    composable(Page.FEED.route) {
        FeedScreen(modifier)
    }
    composable(Page.DISCOVER.route) {
        DiscoverScreen(modifier)
    }
    composable(Page.LIBRARY.route) {
        LibraryScreen(modifier)
    }
    composable(Page.PROFILE.route) {
        ProfileScreen(modifier)
    }
}