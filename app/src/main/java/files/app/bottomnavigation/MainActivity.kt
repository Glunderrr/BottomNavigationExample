package files.app.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import files.app.bottomnavigation.BottomNavigationExample.MainBottomBarScreen
import files.app.bottomnavigation.TopNavigationBar.MainTopBarScreen
import files.app.bottomnavigation.ui.theme.BottomNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationTheme {
                MainTopBarScreen()
                MainBottomBarScreen()
            }
        }
    }
}