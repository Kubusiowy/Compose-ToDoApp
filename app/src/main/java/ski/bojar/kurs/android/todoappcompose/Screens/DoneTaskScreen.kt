package ski.bojar.kurs.android.todoappcompose.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ski.bojar.kurs.android.todoappcompose.data.ToDoViewModel

@Composable
fun DoneTaskScreen(viewModel: ToDoViewModel) {
    val doneTasks = viewModel.todos.filter { it.isDone }

    LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        items(doneTasks){ item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = CardDefaults.cardColors(containerColor = item.color.color)
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = item.title, fontSize = 20.sp, color = Color.Black)
                    Text(text = item.description, fontSize = 14.sp, color = Color.LightGray)
                }
            }


        }


    }
}