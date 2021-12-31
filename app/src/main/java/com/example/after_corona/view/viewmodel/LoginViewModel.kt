package com.example.after_corona.view.viewmodel

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.after_corona.view.SingleLiveEvent
import com.example.after_corona.view.api.RetrofitHelper
import com.example.after_corona.view.data.LoginData
import com.example.after_corona.view.data.LoginResponse
import com.example.after_corona.view.data.SignupData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel: ViewModel() {

    val retrofitHelper = RetrofitHelper.getInstance()       // 레트로핏 헬퍼 객체 생성 (인스턴스화)
    val retrofit = RetrofitHelper.getRetrofit(retrofitHelper)   // 레트로핏 객체 생성
    val api = RetrofitHelper.getLoginAPI(retrofit)
    val onSuccessEvent = SingleLiveEvent<Unit>()


    fun login(id: String, rawPassword: String){
        api.login(LoginData(id=id,rawPassword=rawPassword))
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if(response.isSuccessful)
                    {
                        onSuccessEvent.call()


                    }
                    else{
                        Log.d("TAG", response.code().toString())
                    }

                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

                }

            })



    }
}
