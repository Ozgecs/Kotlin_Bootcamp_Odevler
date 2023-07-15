package com.ozge.survey_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ozge.survey_application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var _binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        with(_binding){
            btngiris.setOnClickListener {
                val name = editTextName.text.toString()

                if (name.isNotEmpty()){
                    val intent = Intent(this@MainActivity, PersonalInfo::class.java)
                    intent.putExtra("name", name)
                    startActivity(intent)
                }else{
                    Toast.makeText(
                        this@MainActivity,
                        "Ad Soyad bilgisi giriniz!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }



    }
}