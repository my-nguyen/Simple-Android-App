/*
 * project: Simple App, Android
 * app.h7.org/simple/Android
 * Copyright © 2018 H7 (h7.org).
 *
 * created by yatko.com
 */

package org.h7.simple.config.menu

import androidx.lifecycle.ViewModel
import android.content.Context
import org.h7.simple.data.menu.Footer
import org.h7.simple.data.menu.Header
import org.h7.simple.data.menu.MenuItem

/**
 * Created by Alexey Rogovoy (lexapublic@gmail.com) on 29.06.2018.
 */
abstract class INavViewModel: ViewModel() {
    abstract fun getMenuFooter(context: Context): Footer
    abstract fun getMenuHeader(context: Context):Header
    abstract fun getMenuItems(): List<MenuItem>
}