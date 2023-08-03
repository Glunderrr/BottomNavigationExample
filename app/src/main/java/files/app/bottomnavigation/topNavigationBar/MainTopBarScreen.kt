package files.app.bottomnavigation.topNavigationBar

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import files.app.bottomnavigation.bottomNavigationExample.MyBottomNavigation
import files.app.bottomnavigation.bottomNavigationExample.NavGraph
import files.app.bottomnavigation.ui.theme.Purple40
import files.app.bottomnavigation.ui.theme.PurpleGrey40
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainTopBarScreen() {
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader()
                DrawerBody()
            }
        }, content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Menu", color = Color.Black) },
                        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.White),
                        navigationIcon = {
                            IconButton(onClick = {
                                coroutineScope.launch {
                                    Log.d("Start_Menu_State", "state:${drawerState.currentValue}")
                                    if (drawerState.isOpen) drawerState.close()
                                    else drawerState.open()
                                    Log.d("End_Menu_State", "state:${drawerState.currentValue}")
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.Menu,
                                    contentDescription = "Menu",
                                    tint = Color.Black,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        val result =
                                            showSnackBar(
                                                snackBarHostState,
                                                "Delete Element",
                                                "Undone"
                                            )
                                        if (result) {
                                            showSnackBar(snackBarHostState, "Element recovered")
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Delete,
                                    contentDescription = "Delete",
                                    tint = Color.Black,
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Filled.AddCircle,
                                    contentDescription = "AddCircle",
                                    tint = Color.Black,
                                )
                            }
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Filled.Share,
                                    contentDescription = "AddCircle",
                                    tint = Color.Black,
                                )
                            }
                        }
                    )
                },
                snackbarHost = {
                    SnackbarHost(hostState = snackBarHostState) {
                        Snackbar(
                            snackbarData = it,
                            modifier = Modifier.padding(20.dp),
                            containerColor = PurpleGrey40,
                            actionColor = Color.White,
                            shape = RoundedCornerShape(20.dp),
                            contentColor = Color.LightGray
                        )
                    }
                },
                content = {
                    NavGraph(navHostController = navController)
                },
                bottomBar = { MyBottomNavigation(navController) }
            )
        })
}


suspend fun showSnackBar(
    snackBarHostState: SnackbarHostState,
    message: String,
    actionLabel: String
): Boolean {
    val result = snackBarHostState.showSnackbar(
        message = message,
        actionLabel = actionLabel,
        duration = SnackbarDuration.Short
    )
    return result == SnackbarResult.ActionPerformed
}

suspend fun showSnackBar(
    snackBarHostState: SnackbarHostState,
    message: String
) {
    snackBarHostState.showSnackbar(
        message = message,
        duration = SnackbarDuration.Short
    )
}


@Composable
fun DrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Header", fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun DrawerBody() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(20) {
            Text(
                modifier = Modifier.padding(20.dp),
                text = "Menu item ${it + 1}"
            )
        }
    }
}