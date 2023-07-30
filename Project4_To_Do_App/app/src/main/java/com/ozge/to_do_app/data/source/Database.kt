package com.ozge.to_do_app.data.source

import android.widget.Toast
import com.ozge.to_do_app.data.model.ToDo

object Database {


    private val todomodel = mutableListOf<ToDo>()
    var todoList = mutableListOf<ToDo>()
    var completedList = mutableListOf<ToDo>()

    fun getTodo() = todoList
    fun getCompleted() = completedList

    // Yapılacaklar kısmı
    fun addToDoItem(title: String, desc: String, date: String, saveType: String) {
        todoList.add(
            ToDo(
                id = (todoList.lastOrNull()?.id ?: 0) + 1,
                title = title,
                desc = desc,
                date = date,
                saveType = saveType
            )
        )
    }

    fun removeToDoItem(todo: ToDo) = todoList.remove(todo)


    fun addCompletedItem(title: String, desc:String, date: String, saveType: String){
        completedList.add(
            ToDo(
                id = (completedList.lastOrNull()?.id ?: 0) + 1,
                title = title,
                desc = desc,
                date = date,
                saveType = saveType
            )
        )

    }

    fun removeCompletedItem(todo: ToDo) = completedList.remove(todo)

}