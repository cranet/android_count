package com.toad.counter

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import java.util.*

class Event(private val context: Context) {

     lateinit var animation: Animation
     lateinit var text: String
     lateinit var phrase: String


    fun isEvent(count: Int): Boolean {
        if (count % getEventIncrement(count) == 0) {

            val array = context.resources.getStringArray(R.array.event_strings)
            text = array[random(array.size)].toString()
            animation = AnimationUtils.loadAnimation(context, R.anim.bounce)
//            text = context.getString(R.string.app_name)
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

    private fun random(to: Int): Int {
        val random = Random()
        return random.nextInt(to - 0)
    }
}