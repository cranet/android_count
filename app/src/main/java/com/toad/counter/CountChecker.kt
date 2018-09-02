package com.toad.counter

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils

class CountChecker {

    fun isEvent(count: Int): Boolean {
        return count % getEventIncrement(count) == 0
    }

    private fun getEventIncrement(count: Int): Int {
        return when (count) {

            in 1..100 -> 10
            in 100..505 -> 15
            in 505..1000 -> 25
            else -> 10
        }

    }

    fun getAnim(context: Context, count: Int): Animation? {

        return when (count) {
            1 -> AnimationUtils.loadAnimation(context, R.anim.bounce)

            else -> null

        }
    }

    fun getText(count: Int): String? {
        return when (count) {
            1 -> "Nice"

            else -> null
        }
    }
}