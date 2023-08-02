package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val btn1 = findViewById<Button>(R.id.btn_login)
        btn1.setOnClickListener {
            val idData = findViewById<EditText>(R.id.id_data)
            val passwordData = findViewById<EditText>(R.id.pw_data)
            val id = idData.text.toString()
            val password = passwordData.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("dataFromId",id)
            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
        val btn2 = findViewById<Button>(R.id.btn_signup)
        btn2.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
