package com.ozge.to_do_app.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ozge.to_do_app.data.model.ToDo
import com.ozge.to_do_app.databinding.TodoItemBinding

class ToDoAdapter (

    var onToDoClick: (ToDo) -> Unit ,
    var onCheckBoxClick: (ToDo) -> Unit= {}

): RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    private val todoList = mutableListOf<ToDo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ToDoViewHolder(
            TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) =
        holder.bind(todoList[position])

    inner class ToDoViewHolder(private val binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: ToDo) {
            with(binding) {
                tvTitle.text = todo.title
                tvDate.text = todo.date

                checkbox.setOnCheckedChangeListener { _, isChecked ->
                    onCheckBoxClick(todo)
                }
                root.setOnClickListener{
                    onToDoClick(todo)
                }
            }
        }
    }

    fun updateList(list: List<ToDo>) {
        todoList.clear()
        todoList.addAll(list)
        notifyItemRangeChanged(0, list.size)
    }

    override fun getItemCount() = todoList.size


}



