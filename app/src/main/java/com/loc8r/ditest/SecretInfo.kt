package com.loc8r.ditest

import javax.inject.Inject

/**
 * STEP #4. We add the @Inject annotation to the class to let Dagger2 know that it is injectable.
 * Actually we're adding @Inject to the class constructor.  Kotlin allows you to skip the
 * constructor, but since we're adding @Inject we need to added it back to the class
 */

class SecretInfo @Inject constructor() {
    val cool_dude = "Steve Zaske"
}