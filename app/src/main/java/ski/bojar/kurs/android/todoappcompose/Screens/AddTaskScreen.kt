package ski.bojar.kurs.android.todoappcompose.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import ski.bojar.kurs.android.todoappcompose.data.ColorsEnum
import ski.bojar.kurs.android.todoappcompose.data.ToDoViewModel

@Composable
fun AddTaskScreen(navController: NavHostController,viewModel: ToDoViewModel)
{

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var selectedColor by remember { mutableStateOf(ColorsEnum.WHITE) }

   Column(modifier = Modifier.fillMaxSize()
       .background(Color.Transparent)
    ,horizontalAlignment = CenterHorizontally
   ) {
       Card(modifier = Modifier.fillMaxWidth().padding(10.dp),
           colors = CardDefaults.cardColors(
               containerColor = selectedColor.color
           )
           ) {
           Column(modifier = Modifier.fillMaxWidth().padding(10.dp)
           ,horizontalAlignment = CenterHorizontally
           ) {

               OutlinedTextField(
                   modifier = Modifier.fillMaxWidth(),
                   value = title,
                   onValueChange = { title = it },
                   label = { Text("Title") },
                   placeholder = { Text("Wpisz cos...") },
               )
               Spacer(Modifier.height(10.dp))
               OutlinedTextField(
                   modifier = Modifier.fillMaxWidth(),
                   value = description,
                   onValueChange = { description = it },
                   label = { Text("Description") },
                   placeholder = { Text("Wpisz cos...") },
               )
               Spacer(Modifier.height(30.dp))

               LazyRow(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceAround
               ) {
                  items( ColorsEnum.values()) { colorEnum ->
                       Box(
                           modifier = Modifier
                               .padding(8.dp)
                               .size(50.dp)
                               .background(colorEnum.color, shape = CircleShape)
                               .border(
                                   width = if (selectedColor == colorEnum) 3.dp else 1.dp,
                                   color = if (selectedColor == colorEnum) Color.Black else Color.Gray,
                                   shape = CircleShape
                               )
                               .clickable {
                                   selectedColor = colorEnum
                               }
                       )
                   }
           }

       }
           Spacer(Modifier.height(40.dp))

           Button(
               onClick = {
                   viewModel.addTodo(title = title, description = description, color = selectedColor)
                   navController.popBackStack()
               },
               modifier = Modifier.align(CenterHorizontally)
           ) {
               Text(text = "Add Task")
           }
   }
}}
