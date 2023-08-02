package files.app.bottomnavigation.BottomNavigationExample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
@Composable
fun Screen1() {
    "Home".ScreenLayout()
}
@Composable
fun Screen2() {
    "Search".ScreenLayout()
}
@Composable
fun Screen3() {
    "History".ScreenLayout()
}
@Composable
fun Screen4() {
    "My account".ScreenLayout()
}
@Composable
private fun String.ScreenLayout() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = this@ScreenLayout)
    }
}