package com.example.after_corona.view.viewmodel

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.after_corona.view.SingleLiveEvent
import com.example.after_corona.view.api.RetrofitHelper
import com.example.after_corona.view.data.SignupData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupViewModel: ViewModel() {

    val retrofitHelper = RetrofitHelper.getInstance()       // 레트로핏 헬퍼 객체 생성 (인스턴스화)
    val retrofit = RetrofitHelper.getRetrofit(retrofitHelper)   // 레트로핏 객체 생성
    val api = RetrofitHelper.getSignupAPI(retrofit)
    val onSuccessEvent = SingleLiveEvent<Unit>()


    fun signup(id : String, name : String, password : String, phoneNumber:String,duraction: Int,callbackUrl:String){
        api.signup(SignupData(id=id,name=name,password=password,phoneNumber = phoneNumber, duraction=duraction,callbackUrl=callbackUrl))
            .enqueue(object : Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful)
                    {
                        onSuccessEvent.call()

                    }
                    else{
                        Log.d(TAG, response.code().toString())
                    }

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {

                }

            })



    }
}