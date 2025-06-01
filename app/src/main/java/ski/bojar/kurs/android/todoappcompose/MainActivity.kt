package ski.bojar.kurs.android.todoappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import ski.bojar.kurs.android.todoappcompose.SetNavGraph.setNavGraph
import ski.bojar.kurs.android.todoappcompose.data.ToDoViewModel
import ski.bojar.kurs.android.todoappcompose.ui.theme.ToDoAppCOMPOSETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel: ToDoViewModel = viewModel()
            val navController = rememberNavController()
            val context = LocalContext.current

            LaunchedEffect(true) {
                viewModel.loadTodos(context)
            }

            setNavGraph(navController,viewModel)
        }
    }
}
