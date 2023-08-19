package com.ozge.booksretrofit.data.source.remote

import com.ozge.booksretrofit.common.Constants.Endpoint.GET_BOOKS
import com.ozge.booksretrofit.common.Constants.Endpoint.GET_BOOK_DETAIL
import com.ozge.booksretrofit.data.model.GetBookDetailResponse
import com.ozge.booksretrofit.data.model.GetBooksResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET(GET_BOOKS)
    fun getBooks(): Call<GetBooksResponse>

    @GET(GET_BOOK_DETAIL)
    fun getBookDetail(
        @Query("id") id: Int
    ): Call<GetBookDetailResponse>
}