package com.loc8r.ditest.di

import com.loc8r.ditest.MainActivity
import dagger.Component

/**
 * The @Component annotation lets Dagger2 know that this is the interface it should use
 * to create dependencies.
 */
@Component
interface AppComponent {

    /**
     * This function interface tells Dagger2 that we want to inject dependencies into
     * MainActivity.  But how does Dagger2 know what to inject?  See STEP #4.
     */
    fun inject(activity: MainActivity)
}