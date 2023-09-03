package com.ozge.retrofitmvvm.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ozge.retrofitmvvm.data.model.Book
import com.ozge.retrofitmvvm.data.model.GetBookDetailResponse
import com.ozge.retrofitmvvm.data.model.GetBooksResponse
import com.ozge.retrofitmvvm.data.source.BookService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksRepository(private val bookService: BookService) {

    val booksLiveData = MutableLiveData<List<Book>?>()
    val bookDetailLiveData = MutableLiveData<Book?>()
    val errorMessageLiveData = MutableLiveData<String>()
    val loadingLiveData = MutableLiveData<Boolean>()


    fun getBooks() {
        loadingLiveData.value = true
        bookService.getBooks().enqueue(object : Callback<GetBooksResponse> {
            override fun onResponse(
                call: Call<GetBooksResponse>,
                response: Response<GetBooksResponse>
            ) {
                val result = response.body()?.books

                if (result.isNullOrEmpty().not()) {
                    booksLiveData.value = result as List<Book>?
                } else {
                    booksLiveData.value = null
                }
                loadingLiveData.value = false
            }

            override fun onFailure(call: Call<GetBooksResponse>, t: Throwable) {
                errorMessageLiveData.value = t.message.orEmpty()
                loadingLiveData.value = false
                Log.e("GetBooks:", t.message.orEmpty())
            }

        })
    }

    fun getBookDetail(id: Int) {
        bookService.getBookDetail(id)
            .enqueue(object : Callback<GetBookDetailResponse> {
                override fun onResponse(
                    call: Call<GetBookDetailResponse>, response: Response<GetBookDetailResponse>
                ) {
                    bookDetailLiveData.value = response.body()?.book
                    loadingLiveData.value = false
                }

                override fun onFailure(call: Call<GetBookDetailResponse>, t: Throwable) {
                    errorMessageLiveData.value = t.message.orEmpty()
                    loadingLiveData.value = false
                    Log.e("GetBooks:", t.message.orEmpty())
                }

            })
    }
}