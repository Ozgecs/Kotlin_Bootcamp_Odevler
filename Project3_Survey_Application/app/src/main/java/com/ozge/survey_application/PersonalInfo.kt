package com.ozge.survey_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ozge.survey_application.classes.User
import com.ozge.survey_application.databinding.ActivityPersonalInfoBinding

class PersonalInfo : AppCompatActivity() {
    private lateinit var _binding:ActivityPersonalInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPersonalInfoBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        with(_binding){

            val name = intent.getStringExtra("name")
            nameSurname.text=name

            buttonbasla.setOnClickListener {

                val nameSurname = name.toString()
                val age = etage.text.toString()
                val country = etCountry.text.toString()
                val city = etCity.text.toString()
                val email = etMail.text.toString()

                if (age.isNotEmpty() && city.isNotEmpty() && country.isNotEmpty() && email.isNotEmpty()) {
                    val user = User(nameSurname, age.toInt(), country, city, email)
                    val intent = Intent(this@PersonalInfo, Survey::class.java)
                    intent.putExtra("user", user)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@PersonalInfo,
                        "Alanları boş bırakmayınız!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}