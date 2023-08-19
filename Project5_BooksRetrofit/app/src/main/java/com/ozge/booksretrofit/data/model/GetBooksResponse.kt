package com.ozge.booksretrofit.data.model


import com.google.gson.annotations.SerializedName

data class GetBooksResponse(

    val books: List<Book?>?,
    val message: String?,
    val success: Int?

)