package ski.bojar.kurs.android.todoappcompose.data

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

data class ToDoItem(val id: Int
                    ,val title: String
                    ,val description: String
                    ,val color: ColorsEnum
                    ,var isDone: Boolean = false)
enum class ColorsEnum(val color: Color){
    RED(Color.Red),
    GREEN(Color.Green),
    BLUE(Color.Blue),
    YELLOW(Color.Yellow),
    PURPLE(Color.Magenta),
    WHITE(Color.White),
    BLACK(Color.Black),
    CYAN(Color.Cyan)
}

class ToDoViewModel:ViewModel()
{
    private var nextId = 0;
    val todos = mutableStateListOf<ToDoItem>()

    @SuppressLint("NewApi")
    fun addTodo(title: String, description: String, color: ColorsEnum){

            todos.addLast(ToDoItem(id = nextId++, title = title, description =  description.trim(), color = color))

    }

    fun removeTodo(id: Int){
        todos.removeAll{it.id == id}
    }

    fun toggleDone(id:Int){
        val item = todos.find { it.id == id }
        item?.let { it.isDone = !it.isDone }
    }

}