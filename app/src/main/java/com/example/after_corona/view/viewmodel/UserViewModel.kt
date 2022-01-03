package com.example.after_corona.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.after_corona.view.SingleLiveEvent
import com.example.after_corona.view.api.RetrofitHelper
import com.example.after_corona.view.data.GetTodoData
import com.example.after_corona.view.data.UserData
import com.example.after_corona.view.data.UserRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserViewModel: ViewModel() {



    val retrofitHelper = RetrofitHelper.getInstance()       // 레트로핏 헬퍼 객체 생성 (인스턴스화)
    val retrofit = RetrofitHelper.getRetrofit(retrofitHelper)   // 레트로핏 객체 생성
    val api = RetrofitHelper.getUserAPI(retrofit)
    val onFailureEvent = SingleLiveEvent<Unit>()
    val onSuccessEvent = SingleLiveEvent<Unit>()
    private val _userData = MutableLiveData<UserData>()
    val userData : LiveData<UserData>
        get() = _userData


    fun getUser(id:String){
        api.getUserData(id)
            .enqueue(object : Callback<UserData>{
                override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                    if(response.isSuccessful){
                        _userData.value = response.body()
                    }
                    else{
                        onFailureEvent.call()
                    }
                }

                override fun onFailure(call: Call<UserData>, t: Throwable) {
                    onFailureEvent.call()
                }

            })

    }

    fun putUser(id :String, password:String,phoneNumber:String,name:String){
        api.putUserData(id, UserRequest(password, name, phoneNumber)).enqueue(object : Callback<UserData>{
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                if(response.isSuccessful){
                    onSuccessEvent.call()
                }
                else{
                    onFailureEvent.call()
                }
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                onFailureEvent.call()
            }

        })

    }

}