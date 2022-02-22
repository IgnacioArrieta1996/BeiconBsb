package com.beiconbsb.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.beiconbsb.R
import com.beiconbsb.databinding.ActivityLoginBinding
import com.beiconbsb.ui.signup.SignUpActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logInBtnCheckIn.setOnClickListener{
            goToSignUp()
        }
    }

    private fun goToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }
}