package com.example.after_corona.view.api

import com.example.after_corona.view.data.SignupData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupInterface {

    @POST("api/v1/register-api/register")
    fun signup(
        @Body userData : SignupData
    ): Call<Void>



}

