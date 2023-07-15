package com.ozge.survey_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.ozge.survey_application.classes.Info
import com.ozge.survey_application.databinding.ActivityResultBinding

class Result : AppCompatActivity() {
    private lateinit var _binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        with(_binding){

            val info = intent.getParcelableExtra("info") as Info?

            // Kişisel Bilgiler
            tvAd.text = info?.user?.name.toString()
            tvYas.text = info?.user?.age.toString()
            tvUlke.text = info?.user?.country.toString()
            tvSehir.text = info?.user?.city.toString()
            tvMail.text = info?.user?.email.toString()

            // Anket Cevapları
            tvYemek.text = info?.food.toString()
            tvSark.text = info?.song.toString()
            tvKitap.text = info?.book.toString()

            button.setOnClickListener {
                val intent = Intent(this@Result, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }

        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!isEnabled) {
                    return
                }

                isEnabled = false

                Toast.makeText(this@Result, "Ana Sayfaya dönmek için tekrar basınız.", Toast.LENGTH_SHORT).show()

                // 2 saniye içinde tekrar basılırsa 1. sayfaya geçiş yap
                Thread {
                    Thread.sleep(2000)
                    isEnabled = true
                }.start()
            }
        })
    }
}