package com.beiconbsb.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.viewModels
import com.beiconbsb.MainActivity
import com.beiconbsb.R
import com.beiconbsb.core.Status
import com.beiconbsb.databinding.ActivitySplashBinding
import com.beiconbsb.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.schedule

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler().postDelayed({
            checkUser()
        }, 5000)



    }

    private fun checkUser() {
        viewModel.isUserLogged().observe(this, { result ->
            when (result) {
                is Status.Loading -> {
                    //Esto queda asi, no hace falta mostrar carga
                }
                is Status.Success -> {
                    navigate(result.data)
                }
                is Status.Failure -> {
                    //TODO Si algo falla, habría que recargar la app
                    Log.d("LOGEADO?", result.exception.toString())
                }
            }
        })
    }

    private fun navigate(status: Boolean) {

        if (status) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}