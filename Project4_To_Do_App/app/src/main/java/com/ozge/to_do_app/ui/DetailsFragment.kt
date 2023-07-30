package com.ozge.to_do_app.ui

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozge.to_do_app.R
import com.ozge.to_do_app.common.viewBinding
import com.ozge.to_do_app.data.source.Database
import com.ozge.to_do_app.databinding.FragmentDetailsBinding


/**
 * Created on 29.07.2023
 * @author Özge Şahin
 */

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val args:DetailsFragmentArgs by navArgs()

    private val binding by viewBinding(FragmentDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            title.text = args.todo.title
            date.text = args.todo.date
            details.text = args.todo.desc


            button2.setOnClickListener {
                AlertDialog.Builder(requireContext())
                    .setTitle("Silme İşlemi")
                    .setMessage("Silmek istediğinize emin misiniz?")
                    .setPositiveButton("Evet"){_,_ ->
                        // item hangi taraftaysa onu silmeli
                        if (args.fromtoDo){
                            Database.removeToDoItem(args.todo)
                            requireContext().toastMessage("Başarıyla silindi")
                        }
                        else{
                            Database.removeCompletedItem(args.todo)
                            requireContext().toastMessage("Başarıyla silindi")
                        }
                    }
                    .setNegativeButton("Hayır",null)
                    .show()
            }

            button1.setOnClickListener {
                val action = DetailsFragmentDirections.actionDetailsFragmentToToDoFragment()
                findNavController().navigate(action)
            }
        }

    }

    fun Context.toastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}