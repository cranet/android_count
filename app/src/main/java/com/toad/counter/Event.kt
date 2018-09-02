package com.toad.counter

import android.content.Context
import android.view.animation.Animation

class Event(private val context: Context) {

     lateinit var animation: Animation
     lateinit var text: String
     lateinit var phrase: String


    fun isEvent(count: Int): Boolean {
        if (count % getEventIncrement(count) == 0) {
//            text = context.resources.getStringArray(R.array.event_strings))
            text = context.getString(R.string.app_name)
            return true
        }
        return false
    }

    private fun getEventIncrement(count: Int): Int {
        return when (count) {

            in 1..100 -> 10
            in 100..505 -> 15
            in 505..1000 -> 25
            else -> 10
        }

    }
}