package com.example.after_corona.view.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.after_corona.view.SingleLiveEvent
import com.example.after_corona.view.api.HomeInterface
import com.example.after_corona.view.api.RetrofitHelper
import com.example.after_corona.view.data.LoginData
import com.example.after_corona.view.data.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {

    val retrofitHelper = RetrofitHelper.getInstance()       // 레트로핏 헬퍼 객체 생성 (인스턴스화)
    val retrofit = RetrofitHelper.getRetrofit(retrofitHelper)   // 레트로핏 객체 생성
    val api =RetrofitHelper.getHomeAPI(retrofit)
    val onCoronaEndSuccessEvent = SingleLiveEvent<Unit>()
    val onCoronaEndFailureEvent = SingleLiveEvent<Unit>()


    fun getUser(){
        api.getUser()
            .enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.code() == 200) {
                        onCoronaEndSuccessEvent.call()

                    } else {

                        onCoronaEndFailureEvent.call()

                    }
                }




                override fun onFailure(call: Call<Void>, t: Throwable) {
                    onCoronaEndFailureEvent.call()

                }
            })
    }
}
