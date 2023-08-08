package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val randomImage = listOf(
            R.drawable.random1,
            R.drawable.random2,
            R.drawable.random3,
            R.drawable.random4,
            R.drawable.random5
        )
        val randomIndex = Random.nextInt(randomImage.size)
        val imageRandom = findViewById<ImageView>(R.id.random_img)
        imageRandom.setImageResource(randomImage[randomIndex])


        val id = intent.getStringExtra("dataFromId")
        val idText = findViewById<TextView>(R.id.id_text)
        idText.text = "아이디 : $id"

        val btnClose = findViewById<ConstraintLayout>(R.id.btn_close)
        btnClose.setOnClickListener {
            finish()
        }
    }
}