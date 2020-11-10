package com.bolaware.swipeoptionsdemoapp

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        motion.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                when(p1?.action){
                    MotionEvent.ACTION_UP -> {
                        if(motion.progress > 0.5){
                            //motion.progress = 100f
                            Handler().postDelayed({

                                ObjectAnimator.ofFloat(
                                    motion,
                                    "progress",
                                    1f
                                ).apply {
                                    duration = 300
                                    start()
                                }
                            }, 0)
                            } else {
                            //motion.progress = 0f
                            Handler().postDelayed({

                                ObjectAnimator.ofFloat(
                                    motion,
                                    "progress",
                                    0f
                                ).apply {
                                    duration = 300
                                    start()
                                }
                            }, 0)
                        }

                        return true
                    }
                }
                return false
            }
        })
    }
}
