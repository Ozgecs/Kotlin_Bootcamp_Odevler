package com.ozge.booksretrofit.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ozge.booksretrofit.MainApplication
import com.ozge.booksretrofit.R
import com.ozge.booksretrofit.common.viewBinding
import com.ozge.booksretrofit.data.model.GetBooksResponse
import com.ozge.booksretrofit.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created on 19.08.2023
 * @author Özge Şahin
 */

class HomeFragment : Fragment(R.layout.fragment_home), BooksAdapter.BookListener{

    // Burası extension Func
    private val binding by viewBinding(FragmentHomeBinding::bind)

    private val booksAdapter by lazy { BooksAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvBooks.adapter = booksAdapter
        getBooks()
    }

    private fun getBooks() {
        MainApplication.bookService?.getBooks()?.enqueue(object : Callback<GetBooksResponse> {
            override fun onResponse(
                call: Call<GetBooksResponse>,
                response: Response<GetBooksResponse>
            ) {

                val result = response.body()?.books

                if (result.isNullOrEmpty().not()) {
                    booksAdapter.submitList(result)
                }

            }

            override fun onFailure(call: Call<GetBooksResponse>, t: Throwable) {
                Log.e("GetBooks", t.message.orEmpty())
            }

        })
    }

    override fun onBookClick(id: Int) {

        val action = HomeFragmentDirections.homeToDetail(id)
        findNavController().navigate(action)
    }
}
