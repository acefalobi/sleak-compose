package com.aceinteract.sleak

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Album
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MusicNote
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.QueueMusic
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.aceinteract.sleak.ui.theme.SleakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SleakTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val selectedPosition = mutableStateOf(0)
                    Tabs(
                        listOf(
                            Icons.Rounded.Home to "Home",
                            Icons.Rounded.Album to "Album",
                            Icons.Rounded.MusicNote to "Songs",
                            Icons.Rounded.QueueMusic to "Playlists",
                            Icons.Rounded.Person to "Artists"
                        ),
                        selectedPosition,
                    ) {
                        selectedPosition.value = it
                        Toast.makeText(this@MainActivity, "Selected: $it", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SleakTheme {
        Tabs(
            listOf(
                Icons.Rounded.Home to "Home",
                Icons.Rounded.Album to "Album",
                Icons.Rounded.MusicNote to "Songs",
                Icons.Rounded.QueueMusic to "Playlists",
                Icons.Rounded.Person to "Artists"
            )
        ) {

        }
    }
}

@Composable
fun Tabs(
    tabs: List<Pair<ImageVector, String>>,
    selectedPosition: State<Int> = mutableStateOf(0),
    onTabClicked: (Int) -> Unit
) {
    val position by selectedPosition
    TabRow(selectedTabIndex = position, backgroundColor = Color.White) {
        tabs.forEachIndexed { i, tab ->
            val tabColor = if (position == i) {
                MaterialTheme.colors.primaryVariant
            } else {
                colorResource(R.color.grey)
            }
            Tab(
                position == i,
                { onTabClicked(i) },
                icon = { Icon(tab.first, tab.second, tint = tabColor) },
            )
        }
    }

}