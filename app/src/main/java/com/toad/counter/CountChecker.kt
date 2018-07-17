package com.toad.counter

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils

class CountChecker {

    fun checkCount(context: Context, count: Int): Animation? {

        return when (count) {
            10 -> AnimationUtils.loadAnimation(context, R.anim.bounce)

            else -> null

        }
    }
}