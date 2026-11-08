/*
 * project: Simple App, Android
 * app.h7.org/simple/Android
 * Copyright © 2018 H7 (h7.org).
 *
 * created by yatko.com
 */

package org.h7.simple.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate


/**
 * * Created by Alexey Rogovoy (lexapublic@gmail.com) on 26.06.2018.
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

}