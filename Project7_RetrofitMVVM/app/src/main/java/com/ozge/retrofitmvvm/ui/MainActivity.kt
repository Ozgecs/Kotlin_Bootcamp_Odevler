package com.ozge.retrofitmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozge.retrofitmvvm.R
import com.ozge.retrofitmvvm.common.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}