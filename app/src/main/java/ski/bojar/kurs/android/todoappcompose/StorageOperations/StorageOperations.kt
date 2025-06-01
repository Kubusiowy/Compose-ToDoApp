package ski.bojar.kurs.android.todoappcompose.StorageOperations

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import ski.bojar.kurs.android.todoappcompose.data.ToDoItem
import java.io.File

object StorageOperations {

    private const val FILE_NAME = "todos.json"

    private val moshi = Moshi.Builder().build()
    private val listType = Types.newParameterizedType(List::class.java, ToDoItem::class.java)
    private val adapter = moshi.adapter<List<ToDoItem>>(listType)

    fun save(context: Context, todos: List<ToDoItem>) {
        val json = adapter.toJson(todos)
        File(context.filesDir, FILE_NAME).writeText(json)
    }

    fun load(context: Context): List<ToDoItem> {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return emptyList()
        val json = file.readText()
        return adapter.fromJson(json) ?: emptyList()
    }

}