package com.ozge.survey_application.classes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(

    val user: User?,
    val food: String,
    val song: String,
    val book: String,

    ) : Parcelable