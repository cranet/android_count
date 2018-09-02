package com.toad.counter

interface CountCallback {
    fun onEvent()

    fun onCount(count: Int)
}
