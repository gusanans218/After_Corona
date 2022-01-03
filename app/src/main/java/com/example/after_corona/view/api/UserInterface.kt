package com.example.after_corona.view.api

import com.example.after_corona.view.data.UserData
import com.example.after_corona.view.data.UserRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserInterface {
    @GET("/api/v1/account-api/account/{id}")
    fun getUserData(
        @Path("id") id : String
    ) : Call<UserData>


    @PUT("/api/v1/account-api/account/{id}")
    fun putUserData(
        @Path("id") id : String,
        @Body request: UserRequest
    ) : Call<UserData>

}