package ski.bojar.kurs.android.todoappcompose.SetNavGraph

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ski.bojar.kurs.android.todoappcompose.Screens.AddTaskScreen
import ski.bojar.kurs.android.todoappcompose.Screens.HomeScreen
import ski.bojar.kurs.android.todoappcompose.Screens.items.BottomMenuNav.BottomMenu
import ski.bojar.kurs.android.todoappcompose.Screens.items.BottomMenuNav.TopBar
import ski.bojar.kurs.android.todoappcompose.data.Screens
import ski.bojar.kurs.android.todoappcompose.data.ToDoViewModel

@Composable
fun setNavGraph(navController:NavHostController,viewModel: ToDoViewModel){

    val currentBackStackEntry by navController.currentBackStackEntryFlow.collectAsState(
        initial = navController.currentBackStackEntry)
    val currentRoute = currentBackStackEntry?.destination?.route ?: Screens.Home.route

    Scaffold( modifier = Modifier.padding(WindowInsets.systemBars.asPaddingValues()),
        bottomBar = {
            BottomMenu(navController = navController, currentRoute = currentRoute)
        },
        topBar = {
            TopBar()
        },
    ) {padding ->
        NavHost(navController = navController, startDestination = Screens.Home.route,
            modifier = Modifier.padding(padding)) {

            composable(route = Screens.Home.route) {
                HomeScreen(navController,viewModel)
            }

            composable(route = Screens.AddTask.route) {
                AddTaskScreen(navController,viewModel)
            }


        }
    }
}