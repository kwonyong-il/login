package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signUpNameData = findViewById<EditText>(R.id.signup_name_data)
        val signUpIdData = findViewById<EditText>(R.id.signup_id_data)
        val signUpPwData = findViewById<EditText>(R.id.signup_pw_data)
        val btnSignUp = findViewById<Button>(R.id.btn_signup_page)

        btnSignUp.setOnClickListener {
            val signUpName = signUpNameData.text.toString()
            val signUpId = signUpIdData.text.toString()
            val signUpPassword = signUpPwData.text.toString()

            if (signUpName.isEmpty() || signUpId.isEmpty() || signUpPassword.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }
}