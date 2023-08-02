package files.app.bottomnavigation.bottomNavigationExample

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import files.app.bottomnavigation.ui.theme.Purple80

val bottomListItems = listOf(
    BottomItem.Screen1,
    BottomItem.Screen2,
    BottomItem.Screen3,
    BottomItem.Screen4
)

@Composable
fun MyBottomNavigation(
    navController: NavController
) {
    BottomAppBar(
        containerColor = Color.White,
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = backStackEntry?.destination?.route
        bottomListItems.forEach { screen ->
            NavigationBarItem(
                selected = currentRout == screen.route,
                onClick = { navController.navigate(screen.route) },
                icon = {
                    Icon(
                        painter = painterResource(screen.iconID),
                        contentDescription = "Img",
                    )
                }, label = {
                    Text(text = screen.item,color = Color.Black)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Purple80,
                    unselectedIconColor = Color.Gray,
                )

            )
        }
    }
}

