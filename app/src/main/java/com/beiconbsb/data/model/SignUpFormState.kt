package com.beiconbsb.data.model

data class SignUpFormState(
    val nameError: Int? = null,
    val lastnameError: Int? = null,
    val emailError: Int? = null,
    val passwordError: Int? = null,
    val samePasswordError: Int? = null,
    val isDataValid: Boolean = false
){
}