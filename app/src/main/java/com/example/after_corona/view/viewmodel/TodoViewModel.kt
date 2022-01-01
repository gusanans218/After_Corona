package com.example.after_corona.view.viewmodel

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.after_corona.view.SingleLiveEvent
import com.example.after_corona.view.api.RetrofitHelper
import com.example.after_corona.view.api.TodoInterface
import com.example.after_corona.view.data.GetTodoData
import com.example.after_corona.view.data.SignupData
import com.example.after_corona.view.data.TodoData
import com.example.after_corona.view.data.TodoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoViewModel: ViewModel() {

    val retrofitHelper = RetrofitHelper.getInstance()       // 레트로핏 헬퍼 객체 생성 (인스턴스화)
    val retrofit = RetrofitHelper.getRetrofit(retrofitHelper)   // 레트로핏 객체 생성
    val api = RetrofitHelper.getTodoAPI(retrofit)
    val onSuccessEvent = SingleLiveEvent<Unit>()
    private val _list = MutableLiveData<List<GetTodoData>>()
    val list : LiveData<List<GetTodoData>>
        get() = _list

    fun postTodo(description:String, title:String){
        api.todopost(TodoData(description,title))
            .enqueue(object : Callback<TodoResponse>{
                override fun onResponse(
                    call: Call<TodoResponse>,
                    response: Response<TodoResponse>
                ) {
                    if(response.isSuccessful)
                    {
                        onSuccessEvent.call()



                    }
                    else{
                        Log.d(ContentValues.TAG, response.code().toString())
                    }

                }

                override fun onFailure(call: Call<TodoResponse>, t: Throwable) {
                }

            })




    }

    fun getTodo(){
        api.todoget()
            .enqueue(object : Callback<List<GetTodoData>> {
                override fun onResponse(
                    call: Call<List<GetTodoData>>,
                    response: Response<List<GetTodoData>>
                ) {
                    if(response.isSuccessful)
                    {
                        _list.value = response.body()

                    }
                    else{
                        Log.d(ContentValues.TAG, response.code().toString())
                    }



                }

                override fun onFailure(call: Call<List<GetTodoData>>, t: Throwable) {
                }

                })

    }
}
