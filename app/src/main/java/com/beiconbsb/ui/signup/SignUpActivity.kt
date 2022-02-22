package com.beiconbsb.ui.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.beiconbsb.MainActivity
import com.beiconbsb.R
import com.beiconbsb.core.Status
import com.beiconbsb.databinding.ActivitySignUpBinding
import com.beiconbsb.ui.BaseActivity
import com.beiconbsb.ui.login.LoginActivity
import com.beiconbsb.utils.afterTextChanged
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BaseActivity() {

    val viewModel: SignUpViewModel by viewModels()
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupTvLogin.setOnClickListener {
            goToLogin()
        }

        setup()
        doSignUp()

    }

    private fun doSignUp() {
        binding.signupBtnRegister.setOnClickListener {
            viewModel.signUp(binding.signupEtEmail.text.toString(), binding.signupEtPassword.text.toString()).observe(this, { result ->
                when (result) {
                    is Status.Loading -> {
                        showProgressDialog()
                        Log.d("ESTADO:", "Loading")
                    }
                    is Status.Success -> {
                        Log.d("ESTADO:", "Succes: ${result.data?.uid}")
                        hideProgressDialog()
                        goToHome()
                    }
                    is Status.Failure -> {
                        Log.d("ESTADO:", "Fail: ${result.exception}")
                        hideProgressDialog()
                    }
                }
            })
        }
    }

    private fun goToHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun setup() {
        dataValidation()
        viewModel.signUpFormState.observe(this, Observer {
            val signUpFormState = it ?: return@Observer

            with(binding) {
                // Button enabled
                cbTermsAndCondition.setOnClickListener {
                    signupBtnRegister.isEnabled =
                        signUpFormState.isDataValid && cbTermsAndCondition.isChecked
                }
                signupBtnRegister.isEnabled =
                    signUpFormState.isDataValid && cbTermsAndCondition.isChecked
                signupEtFirstName.error = signUpFormState.nameError?.let(::getString)
                signupEtLastName.error = signUpFormState.lastnameError?.let(::getString)
                signupEtEmail.error = signUpFormState.emailError?.let(::getString)
                signupEtPassword.error = signUpFormState.passwordError?.let(::getString)
                signupEtConfirmPassword.error = signUpFormState.samePasswordError?.let(::getString)
            }
        })
    }

    private fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun dataValidation() {
        with(binding) {
            signupEtFirstName.afterTextChanged {
                viewModel.onDataChanged(
                    signupEtFirstName.text.toString(),
                    signupEtLastName.text.toString(),
                    signupEtEmail.text.toString(),
                    signupEtPassword.text.toString(),
                    signupEtConfirmPassword.text.toString()
                )
            }

            signupEtEmail.afterTextChanged {
                viewModel.onDataChanged(
                    signupEtFirstName.text.toString(),
                    signupEtLastName.text.toString(),
                    signupEtEmail.text.toString(),
                    signupEtPassword.text.toString(),
                    signupEtConfirmPassword.text.toString()
                )
            }

            signupEtPassword.afterTextChanged {
                viewModel.onDataChanged(
                    signupEtFirstName.text.toString(),
                    signupEtLastName.text.toString(),
                    signupEtEmail.text.toString(),
                    signupEtPassword.text.toString(),
                    signupEtConfirmPassword.text.toString()
                )
            }

            signupEtConfirmPassword.afterTextChanged {
                viewModel.onDataChanged(
                    signupEtFirstName.text.toString(),
                    signupEtLastName.text.toString(),
                    signupEtEmail.text.toString(),
                    signupEtPassword.text.toString(),
                    signupEtConfirmPassword.text.toString()
                )
            }

        }
    }
}