package com.ozge.retrofitmvvm.data.model
data class GetBooksResponse(

    val books: List<Book?>?,
    val message: String?,
    val success: Int?

)