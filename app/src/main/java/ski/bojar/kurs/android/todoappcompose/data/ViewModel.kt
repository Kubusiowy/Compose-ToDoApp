package ski.bojar.kurs.android.todoappcompose.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.squareup.moshi.JsonClass
import ski.bojar.kurs.android.todoappcompose.StorageOperations.StorageOperations


@JsonClass(generateAdapter = true)
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
    fun addTodo(title: String, description: String, color: ColorsEnum,context: Context){
            todos.addLast(ToDoItem(id = nextId++, title = title, description =  description.trim(), color = color))
        saveTodos(context)

    }

    fun removeTodo(id: Int,context: Context){
        todos.removeAll{it.id == id}
        saveTodos(context)
    }

    fun toggleDone(id: Int,context: Context) {
        val index = todos.indexOfFirst { it.id == id }
        if (index != -1) {
            val item = todos[index]
            val updatedItem = item.copy(isDone = !item.isDone)
            todos[index] = updatedItem
            saveTodos(context)
        }
    }

    fun loadTodos(context: Context) {
        val loaded = StorageOperations.load(context)
        todos.clear()
        todos.addAll(loaded)
        nextId = (todos.maxOfOrNull { it.id } ?: 0) + 1
    }

    private fun saveTodos(context: Context) {
        StorageOperations.save(context, todos)
    }

}