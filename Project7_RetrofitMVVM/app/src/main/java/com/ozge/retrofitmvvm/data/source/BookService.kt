package com.ozge.retrofitmvvm.data.source

import com.ozge.retrofitmvvm.common.Constants.Endpoint.GET_BOOKS
import com.ozge.retrofitmvvm.common.Constants.Endpoint.GET_BOOK_DETAIL
import com.ozge.retrofitmvvm.data.model.GetBookDetailResponse
import com.ozge.retrofitmvvm.data.model.GetBooksResponse
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