/*
 * project: Simple App, Android
 * app.h7.org/simple/Android
 * Copyright © 2018 H7 (h7.org).
 *
 * created by yatko.com
 */

package org.h7.simple.data.menu

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import android.graphics.Color

/**
 * * Created by Alexey Rogovoy (lexapublic@gmail.com) on 29.06.2018.
 */
class Header(logoUrl: String?, val title: String?, val subtitle: String?) {
    private val logoUrl = ObservableField<String>()
    var strokeColor = ObservableInt()

    init {
        this.logoUrl.set(logoUrl)
        strokeColor.set(Color.WHITE)
    }

    fun setLogoUrl(url: String) {
        logoUrl.set(url)
    }
    fun getLogoUrl():String?{
        return logoUrl.get()
    }
}
