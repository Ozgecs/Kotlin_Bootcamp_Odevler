package com.ozge.to_do_app.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ozge.to_do_app.R
import com.ozge.to_do_app.common.viewBinding
import com.ozge.to_do_app.data.model.ToDo
import com.ozge.to_do_app.data.source.Database
import com.ozge.to_do_app.databinding.FragmentCompletedBinding
import com.ozge.to_do_app.ui.adapter.ToDoAdapter

/**
 * Created on 29.07.2023
 * @author Özge Şahin
 */

class CompletedFragment : Fragment(R.layout.fragment_completed) {

    private val binding by viewBinding(FragmentCompletedBinding::bind)
    private val completedAdapter = ToDoAdapter(::onToDoClick,::onCheckboxClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData(Database.getCompleted())
        checkBoxClick()
        with(binding) {

        }
    }
    private fun setData(list: List<ToDo>) {
        binding.rvCompleteNote.adapter = completedAdapter
        completedAdapter.updateList(list)
    }
    private fun onCheckboxClick(todo: ToDo) {
        Database.removeCompletedItem(todo)
        setData(Database.getCompleted())
    }
    private fun onToDoClick(todo:ToDo){

    }
        private fun checkBoxClick() {
            completedAdapter.onCheckBoxClick = { todoModel ->
                Database.removeCompletedItem(todoModel)
                todoModel.desc?.let {
                    Database.addToDoItem(
                        todoModel.title,
                        it,
                        todoModel.date,
                        todoModel.saveType
                    )
                }
            }
        }
    }
