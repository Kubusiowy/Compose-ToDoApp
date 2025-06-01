package ski.bojar.kurs.android.todoappcompose.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val route: String,val Title:String,val imageVector: ImageVector) {
    object DoneTask : Screens("doneTask", "Done Task", imageVector = Icons.Default.Done)
    object Home : Screens("home", "Home", imageVector = Icons.Default.Home)
    object AddTask : Screens("addTask", "Add Task", imageVector = Icons.Default.Add)


}