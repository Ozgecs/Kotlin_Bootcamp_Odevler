package com.ozge.booksretrofit.common

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


fun View.gone(){
    visibility= View.GONE
}
fun View.visible(){
    visibility= View.VISIBLE
}

fun ImageView.loadImage(url: String?){
    Glide.with(this.context).load(url).into(this)
}