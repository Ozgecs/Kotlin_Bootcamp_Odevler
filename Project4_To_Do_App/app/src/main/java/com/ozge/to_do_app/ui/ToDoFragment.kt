package com.ozge.to_do_app.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ozge.to_do_app.R
import com.ozge.to_do_app.common.showDatePicker
import com.ozge.to_do_app.common.showTimePicker
import com.ozge.to_do_app.common.viewBinding
import com.ozge.to_do_app.data.model.ToDo
import com.ozge.to_do_app.data.source.Database
import com.ozge.to_do_app.databinding.AddAlertDialogBinding
import com.ozge.to_do_app.databinding.FragmentTodoBinding
import com.ozge.to_do_app.ui.adapter.ToDoAdapter
import java.util.Calendar

/**
 * Created on 29.07.2023
 * @author Özge Şahin
 */

class ToDoFragment : Fragment(R.layout.fragment_todo) {

    private val binding by viewBinding(FragmentTodoBinding::bind)

    private val todo_Adapter = ToDoAdapter(::onToDoClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData(Database.getTodo())
        checkBoxClick()
        with(binding) {

            fabAdd.setOnClickListener {
                showAddDialog()
            }
        }
    }

    private fun setData(list: List<ToDo>){
        binding.rvTodoNotes.adapter = todo_Adapter
        todo_Adapter.updateList(list)
    }
    private fun showAddDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val binding = AddAlertDialogBinding.inflate(layoutInflater)
        builder.setView(binding.root)
        val dialog = builder.create()

        val saveTypeList = listOf("Acil", "Önemli")

        var selectedSaveType = ""

        var selectedDate = ""

        val saveTypeAdapter = ArrayAdapter(
            requireContext(),
            androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            saveTypeList
        )


        with(binding){
            val calendar = Calendar.getInstance()

            actSaveType.setAdapter(saveTypeAdapter)

            actSaveType.setOnItemClickListener { _, _, position, _ ->
                selectedSaveType = saveTypeList[position]
            }

            switchDate.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    showDatePicker(calendar) { year, month, day ->
                        showTimePicker(calendar) { hour, minute ->
                            selectedDate = "$day.$month.$year - $hour:$minute"
                            tvDate.text = "$day.$month.$year - $hour:$minute"
                            tvDate.visibility = View.VISIBLE
                        }
                    }
                }
            }

            btnAdd.setOnClickListener {
                val title = etTitle.text.toString()
                val desc = etDesc.text.toString()

                if (title.isNotEmpty() && desc.isNotEmpty() && selectedSaveType.isNotEmpty()) {
                    Database.addToDoItem(title, desc, selectedDate, selectedSaveType)
                    setData(Database.getTodo())
                    dialog.dismiss()
                }
            }

            btnCancel.setOnClickListener {
                dialog.dismiss()
            }
        }
        dialog.show()
    }

    private fun onToDoClick(ToDo: ToDo) {
        val action = ToDoFragmentDirections.actionToDoFragmentToDetailsFragment(ToDo)
        findNavController().navigate(action)
    }
    private fun checkBoxClick() {
        todo_Adapter.onCheckBoxClick = { todoModel ->
            Database.removeToDoItem(todoModel)
            todoModel.desc?.let {
                Database.addCompletedItem(
                    todoModel.title,
                    it,
                    todoModel.date,
                    todoModel.saveType
                )
            }
        }
    }
}

