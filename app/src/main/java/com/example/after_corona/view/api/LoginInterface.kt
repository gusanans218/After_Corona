package com.example.after_corona.view.api

import com.example.after_corona.view.data.LoginData
import com.example.after_corona.view.data.LoginResponse
import com.example.after_corona.view.data.SignupData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {
    @POST("api/v1/login-api/login")
    fun login(
        @Body userData : LoginData
    ): Call<LoginResponse>

}