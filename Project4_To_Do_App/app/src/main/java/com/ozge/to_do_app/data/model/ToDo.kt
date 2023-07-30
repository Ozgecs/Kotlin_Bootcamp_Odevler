package com.ozge.to_do_app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ToDo(
    val id: Int,
    val title: String,
    val desc: String?,
    val date: String,
    val saveType: String,
):Parcelable