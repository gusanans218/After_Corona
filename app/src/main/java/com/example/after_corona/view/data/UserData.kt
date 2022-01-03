package com.example.after_corona.view.data

data class UserData(
    val id : String,
    val name : String,
    val phoneNumber:String
)

data class UserRequest(
    val password : String,
    val name : String,
    val phoneNumber:String
)