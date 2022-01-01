package com.example.after_corona.view.api

import com.example.after_corona.view.data.GetTodoData
import com.example.after_corona.view.data.SignupData
import com.example.after_corona.view.data.TodoData
import com.example.after_corona.view.data.TodoResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TodoInterface {

    @POST("/api/v1/todo-api/todo")
    fun todopost(
        @Body userData : TodoData
    ): Call<TodoResponse>

    @GET("/api/v1/todo-api/todo")
    fun todoget(
    ): Call<List<GetTodoData>>


}