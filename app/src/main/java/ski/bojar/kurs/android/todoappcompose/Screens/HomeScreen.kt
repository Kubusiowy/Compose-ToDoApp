package ski.bojar.kurs.android.todoappcompose.Screens

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ski.bojar.kurs.android.todoappcompose.data.ColorsEnum
import ski.bojar.kurs.android.todoappcompose.data.Screens
import ski.bojar.kurs.android.todoappcompose.data.ToDoViewModel

@Composable
fun HomeScreen(navController: NavHostController,viewModel: ToDoViewModel) {
        Text(text = "Ilosc zadan: ${viewModel.todos.size}")
        LazyColumn(modifier = Modifier.fillMaxSize().padding(15.dp))
        {
            items(viewModel.todos){item->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = item.color.color
                    )
                )
                {
                    Row(modifier = Modifier.fillMaxSize())
                    {
                        Column(Modifier.fillMaxSize().padding(10.dp).weight(1f))
                        {
                            Text(
                                text = item.title,
                                color = if (item.color.color == Color.Red ||
                                    item.color.color == Color.Red ||
                                    item.color.color == Color.Blue ||
                                    item.color.color == Color.Magenta ||
                                    item.color.color == Color.Black
                                ) Color.LightGray else Color.Black,
                                fontSize = 22.sp,
                                modifier = Modifier
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(
                                text = item.description,
                                color = if (item.color.color == Color.Red ||
                                    item.color.color == Color.Red ||
                                    item.color.color == Color.Blue ||
                                    item.color.color == Color.Magenta ||
                                    item.color.color == Color.Black
                                ) Color.LightGray else Color.Black,
                                fontSize = 14.sp,
                                modifier = Modifier
                            )
                        }
                        Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete",
                            modifier = Modifier.clickable {
                                viewModel.removeTodo(item.id)
                            }
                            )

                    }
                }

            }
        }





}

