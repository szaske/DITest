package com.loc8r.ditest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * STEP #1. An extremely simple Android Application
     *
     * This repo was created to help me learn and understand Dagger2 and Kotlin.  I'll leave it here
     * to help others too.  YOu can walk through each step by checking out different branches.
     *
     * This Project contains one activity and one separate class, that will need to be injected
     * called SecretInfo.
     *
     * STEP #2. Install Dagger2 Dependencies.  See comments in the module build.gradle file for
     * more information on what this entails.
     *
     */
    val info = SecretInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_info.text = info.cool_dude
    }
}
