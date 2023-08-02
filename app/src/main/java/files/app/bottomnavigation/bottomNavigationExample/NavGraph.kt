package files.app.bottomnavigation.bottomNavigationExample

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomItem.Screen1.route
    ) {
        composable(BottomItem.Screen1.route){ Screen1()}
        composable(BottomItem.Screen2.route){ Screen2()}
        composable(BottomItem.Screen3.route){ Screen3()}
        composable(BottomItem.Screen4.route){ Screen4()}
    }
}