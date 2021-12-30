package com.example.after_corona.view

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.Nullable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T?>() {

    private val mPending = AtomicBoolean(false)

    override fun observe(owner: LifecycleOwner, observer: Observer<in T?>) {
        if (hasActiveObservers()) {

            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.")
        }
        super.observe(owner, { t ->
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(@Nullable t: T?) {
        mPending.set(true)
        super.setValue(t)
    }

    @MainThread
    fun call() {
        value = null
        //SingleLiveEvent는 MutableLiveData를 상속 받는다
        //이 SingleLiveEvent의 변수를 call 한다면
        //value = null이 실행 된다
        //value에 값이 들어갔으므로 값이 바뀌었다는 이벤트를 호출할 수 있다
    }

    companion object {
        private const val TAG = "SingleLiveEvent"
    }
}