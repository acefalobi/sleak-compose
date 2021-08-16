package com.aceinteract.sleak.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aceinteract.sleak.R
import com.aceinteract.sleak.ui.theme.SleakTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            Sleak()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProvideWindowInsets {
        SleakTheme {
            val navController = rememberNavController()
            Scaffold(bottomBar = { BottomNav(navController) }) {
                FeedScreen()
            }
        }
    }
}

@Composable
fun Sleak() {
    ProvideWindowInsets {
        SleakTheme {
            val navController = rememberNavController()
            Scaffold(bottomBar = { BottomNav(navController) }) {
                SleakNavGraph(Modifier.padding(it), navController)
            }
        }
    }
}

enum class BottomNavItems(
    @StringRes val title: Int,
    val icon: ImageVector,
    val page: Page,
) {
    HOME(R.string.home, Icons.Outlined.Home, Page.FEED),
    DISCOVER(R.string.discover, Icons.Outlined.Search, Page.DISCOVER),
    LIBRARY(R.string.library, Icons.Outlined.LibraryMusic, Page.LIBRARY),
    PROFILE(R.string.profile, Icons.Outlined.Person, Page.PROFILE);
}

@Composable
fun BottomNav(
    navController: NavController,
    backgroundColor: Color = MaterialTheme.colors.primary,
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    BottomNavigation(Modifier.navigationBarsPadding(start = false, end = false), backgroundColor) {
        BottomNavItems.values().forEach { item ->
            BottomNavigationItem(
                currentRoute == item.page.route,
                {
                    if (currentRoute != item.page.route) {
                        navController.navigate(item.page.route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                    }
                },
                { Icon(item.icon, stringResource(item.title)) },
                label = { Text(stringResource(item.title)) }
            )
        }
    }
}