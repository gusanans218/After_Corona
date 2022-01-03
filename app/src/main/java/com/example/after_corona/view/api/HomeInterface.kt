package com.example.after_corona.view.api

import retrofit2.Call
import retrofit2.http.POST

interface HomeInterface {
    @POST("/api/v1/corona")
    fun getUser (
    ): Call<Void>
}