package com.toad.counter

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import android.view.View

class MainViewModel(context: Context, private val callback: CountCallback) : BaseObservable() {

    private var count: Int = 0
    private var isEvent: Boolean = false
    private val event: Event = Event(context)

    fun onClickCount() {
        count++
        Log.d("log", "onClickCount")
        isEvent = eventCheck(count)
        notifyChange()
//        callback.onCount(count)
    }

    private fun eventCheck(count: Int): Boolean {
        return event.isEvent(count)
    }

    @Bindable
    fun getCurrentCount(): String {
        return count.toString()
    }

    fun onClickReset() {
        count = 0
        Log.d("log", "onClickReset")
        notifyChange()
    }

    @Bindable
    fun getEventVisibility(): Int {
        return if (isEvent) {
            View.VISIBLE
        } else View.GONE

    }

    @Bindable
    fun getEventText(): String {
        return if (isEvent) {
            event.text
        } else ""
    }

//    @Bindable
//    fun getAnimation(): Int {
////        return AnimationUtils.loadAnimation(this.context, R.anim.bounce)
//        return R.anim.bounce
//    }


}