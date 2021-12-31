package com.example.after_corona.view.data

data class LoginResponse (
    val encodedPassword: String,
    val id: String,
    val name: String,
    val phoneNumber: String
)