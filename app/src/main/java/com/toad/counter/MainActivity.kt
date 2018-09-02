package com.toad.counter

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.toad.counter.databinding.ActivityMainBinding
import java.time.Duration

class MainActivity : AppCompatActivity(), CountCallback {

    private lateinit var mBinding: ActivityMainBinding
    private var animDuration: Long = 1000
//    private lateinit var checker: CountChecker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        checker = CountChecker()
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = MainViewModel(this, this)
        mBinding.viewModel = viewModel

    }

    override fun onEvent() {
        Log.d("log", "event")
        val countAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        countAnim.duration = animDuration
        mBinding.textViewCountAnim.startAnimation(countAnim)

        val textAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.up_fade)
        textAnim.duration = animDuration

        countAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationStart(animation: Animation?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onAnimationEnd(animation: Animation?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                mBinding.textViewWord.visibility = View.GONE
            }

        })

        mBinding.textViewWord.startAnimation(textAnim)

    }

    override fun onCount(count: Int) {
        Log.d("log", "count clicked")
//        val animation: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.bounce)

//        //Check count
//        val anim: Animation? = checker.getAnim(this, count)
//        val message: String? = checker.getText(count)
//        //
//        if (anim != null) {
//            mBinding.textView.startAnimation(anim)
//        }


    }

}
