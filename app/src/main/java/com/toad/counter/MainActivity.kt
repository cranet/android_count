package com.toad.counter

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.toad.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CountCallback {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var checker: CountChecker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checker = CountChecker()
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        var viewModel = MainViewModel(this, this)
        mBinding.viewModel = viewModel

    }

    override fun onCount(count: Int) {
        Log.d("log", "count clicked")
//        val animation: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.bounce)
        val anim: Animation? = checker.checkCount(this, count)
        if (anim != null) {
            mBinding.textView.startAnimation(anim)
        }
    }

}
