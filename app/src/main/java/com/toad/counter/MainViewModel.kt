package com.toad.counter

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils

class MainViewModel(private var context: Context, private val callback: CountCallback) : BaseObservable() {

    private var count: Int = 0

    fun onClickCount() {
        count++
        Log.d("log", "onClickCount")
        notifyChange()
        callback.onCount(count)
    }

    @Bindable
    fun getCurrentCount(): String {
        return count.toString()
    }

//    @Bindable
//    fun getAnimation(): Int {
////        return AnimationUtils.loadAnimation(this.context, R.anim.bounce)
//        return R.anim.bounce
//    }


}