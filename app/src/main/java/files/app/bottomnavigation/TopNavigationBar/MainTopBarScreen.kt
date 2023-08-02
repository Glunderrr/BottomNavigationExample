package files.app.bottomnavigation.TopNavigationBar

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainTopBarScreen() {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Menu", color = Color.Black) },
            colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.White),
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu",
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }, actions = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Menu",
                        tint = Color.Black,
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.AddCircle,
                        contentDescription = "Menu",
                        tint = Color.Black,
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Menu",
                        tint = Color.Black,
                    )
                }
            }
        )

    }) {

    }
}