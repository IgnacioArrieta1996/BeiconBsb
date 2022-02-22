package com.beiconbsb.ui.signup

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.beiconbsb.R
import com.beiconbsb.core.Status
import com.beiconbsb.data.model.SignUpFormState
import com.beiconbsb.data.firebaseAuth.signup.SignUpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpRepository: SignUpRepository) :
    ViewModel() {


    private val _signUpFormState = MutableLiveData<SignUpFormState>()
    val signUpFormState: LiveData<SignUpFormState> = _signUpFormState

    fun signUp(email: String, password: String) = liveData(Dispatchers.IO) {

        emit(Status.Loading())

        try {
            emit(Status.Success(signUpRepository.signUp(email, password)))
        } catch (e: Exception) {
            emit(Status.Failure(e))
        }
    }


    // Validate Data
    fun onDataChanged(
        name: String,
        lastName: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        if (!isNameValid(name)) {
            _signUpFormState.value = SignUpFormState(nameError = R.string.signup_name_text)
        } else if (!isNameValid(lastName)) {
            _signUpFormState.value = SignUpFormState(lastnameError = R.string.signup_lastname_text)
        } else if (!isEmailValid(email)) {
            _signUpFormState.value = SignUpFormState(emailError = R.string.signup_email_text)
        } else if (!isPasswordValid(password)) {
            _signUpFormState.value =
                SignUpFormState(passwordError = R.string.signup_password_text)
        } else if (!isPasswordSame(password, confirmPassword)) {
            _signUpFormState.value =
                SignUpFormState(samePasswordError = R.string.signup_same_password_text)
        } else {
            _signUpFormState.value = SignUpFormState(isDataValid = true)
        }

    }


    // Check name
    private fun isNameValid(name: String) =
        Pattern.compile("^(?=\\S+\$).{3,}").matcher(name).matches()

    // Check email
    private fun isEmailValid(email: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    // Check password
    private fun isPasswordValid(password: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=\\S+\$).{8,}"
        val pattern = Pattern.compile(passwordPattern)
        return pattern.matcher(password).matches()
    }

    private fun isPasswordSame(firstPass: String, secondPass: String) =
        firstPass == secondPass
}
