package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id = intent.getStringExtra("dataFromId")
        val id_text = findViewById<EditText>(R.id.id_text)
        id_text.setText(id)

        val btn_close = findViewById<Button>(R.id.btn_close)
        btn_close.setOnClickListener {
            finish()
        }
    }
}