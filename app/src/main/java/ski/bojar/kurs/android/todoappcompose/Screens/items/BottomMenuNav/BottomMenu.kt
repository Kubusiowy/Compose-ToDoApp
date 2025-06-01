package ski.bojar.kurs.android.todoappcompose.Screens.items.BottomMenuNav

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ski.bojar.kurs.android.todoappcompose.data.Screens

@Composable
fun BottomMenu(navController: NavController, currentRoute:String)
{
    NavigationBar(Modifier.fillMaxWidth().height(80.dp), containerColor = Color.Transparent,) {
        listOf(
            Screens.Home,
            Screens.AddTask
        ).forEach { screen ->
            NavigationBarItem(
                icon = { Icon(imageVector = screen.imageVector, contentDescription = screen.Title) },
                label = { Text(text = screen.Title) },
                selected = currentRoute == screen.route,
                onClick = {
                    if(currentRoute != screen.route)
                    {
                        navController.navigate(screen.route){
                            popUpTo(navController.graph.startDestinationId)
                            {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )

        }
    }


}