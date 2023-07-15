package com.ozge.survey_application.classes

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    
    val name: String,
    val age: Int,
    val country: String,
    val city: String,
    val email: String,

    ) :Parcelable
    
