package com.example.login

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    lateinit var resultText: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        val idData = findViewById<EditText>(R.id.id_data)
        val passwordData = findViewById<EditText>(R.id.pw_data)
        val btnOne = findViewById<Button>(R.id.btn_login)

        btnOne.setOnClickListener {
            val id = idData.text.toString()
            val password = passwordData.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("dataFromId", id)
            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
        resultText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val signedUpId = data?.getStringExtra("signedUpId")
                val signedUpPassword = data?.getStringExtra("signedUpPassword")

                // Use the data received from SignUpActivity (if needed)
                idData.setText(signedUpId)
                passwordData.setText(signedUpPassword)
            }
        }

        val btnTwo = findViewById<Button>(R.id.btn_signup)
        btnTwo.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultText.launch(intent)
        }
    }
}
