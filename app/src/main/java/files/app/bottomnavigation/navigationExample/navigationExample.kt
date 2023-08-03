package files.app.bottomnavigation.navigationExample

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import files.app.bottomnavigation.ui.theme.BottomNavigationTheme

@Composable
fun NavigationScreen() {
    val navController = rememberNavController()
    BottomNavigationTheme {
        NavHost(
            navController = navController,
            startDestination = Screen.FIRST.toString()
        ) {
            composable(Screen.FIRST.name) {
                Screen1 { navController.navigate(Screen.SECOND.name) }
            }
            composable(Screen.SECOND.name) {
                Screen2 { navController.navigate(Screen.THIRD.name) }
            }
            composable(Screen.THIRD.name) {
                Screen3 {
                    navController.navigate(Screen.FIRST.name) {
                        popUpTo(Screen.FIRST.name) { inclusive = true }
                    }
                }
            }
        }
    }
}

enum class Screen {
    FIRST,
    SECOND,
    THIRD
}