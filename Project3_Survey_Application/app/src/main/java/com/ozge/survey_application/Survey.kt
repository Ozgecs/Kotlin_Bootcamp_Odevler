package com.ozge.survey_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ozge.survey_application.classes.User
import com.ozge.survey_application.classes.Info
import com.ozge.survey_application.databinding.ActivitySurveyBinding

class Survey : AppCompatActivity() {
    private lateinit var _binding:ActivitySurveyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        with(_binding){

            val user = intent.getParcelableExtra("user") as User?
            nameSurname2.text = user?.name.toString()

            btnsonuc.setOnClickListener {
                val yemek = etcevap1.text.toString()
                val sarkı = etcevap2.text.toString()
                val kitap = etcevap3.text.toString()

                if (yemek.isNotEmpty() && sarkı.isNotEmpty() && kitap.isNotEmpty()) {
                    val info = Info(user, yemek, sarkı, kitap)
                    val intent = Intent(this@Survey, Result::class.java)
                    intent.putExtra("info", info)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@Survey,
                        "Boş Bırakmayınız",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}