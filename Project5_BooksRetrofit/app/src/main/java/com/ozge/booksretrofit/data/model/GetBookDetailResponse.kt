package com.ozge.booksretrofit.data.model

data class GetBookDetailResponse(
    val book: Book?,
    val message: String?,
    val success: Int?
)