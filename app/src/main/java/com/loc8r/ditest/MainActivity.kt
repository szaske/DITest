package com.loc8r.ditest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loc8r.ditest.di.DaggerAppComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

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
     * STEP #3. Creating the Dagger2 Interface.
     *       3a. Create a new package called 'di'
     *       3b. Create a new Kotlin interface file in that folder called AppComponent.
     *
     * See comments in AppComponent.kt for more information on this step.
     *
     * STEP #4. Configuring injectable classes.  We need to tell Dagger2 what classes can be
     * injected.  We do that by adding the @Inject annotation to the class.
     *
     * STEP #5. Alter your class to accept the dependency injections.
     *       5a. Change injected properties/fields to  @Inject lateinit var's
     *       5b. Inject using the Dagger created call (see line 61 below)
     *
     * Now this example is complete.  We've removed the initialization of a dependency and instead
     * injected it using Dagger2
     */


    /**
     * This (the following line of code) is the ugly line of code we want to get rid of.  Why is it
     * so ugly?  It's ugly because it's instantiating a dependency.  In the world of software
     * development that means that this activity source code is dependent on another class to run.
     * Dagger2 helps developers write code that supports the 'Separation of concerns'
     * @see https://en.wikipedia.org/wiki/Separation_of_concerns...and this code as written does
     * not.  In this simple example 'Separation of concerns' is overkill, but it's good practice
     * to follow it on professional projects.
     */
    // Step #5 was -> val info = SecretInfo(). lateinit allows us to compile without causing an error
    // because the non-null variable has not been initialize in the constructor.
    @Inject lateinit var info: SecretInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Now we tell Dagger to inject, using the interface we created by called
         * DaggerAppComponent.create().  Wait, what?  Where did this DaggerAppComponent class come
         * from?  IMO this is the most confusing part about Dagger2.  Dagger creates this class as
         * part of it's magic, and when you type this line Android Studio code-completion will not
         * recognize it until after you build or rebuild the project.
         */
        DaggerAppComponent.create().inject(this)
        text_info.text = info.cool_dude
    }
}
