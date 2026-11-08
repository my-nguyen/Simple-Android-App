/*
 * project: Simple App, Android
 * app.h7.org/simple/Android
 * Copyright © 2018 H7 (h7.org).
 *
 * created by yatko.com
 */

package org.h7.simple.activity.main

import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import org.h7.simple.R
import org.h7.simple.activity.main.adapter.MenuAdapter
import org.h7.simple.config.menu.INavViewModel
import org.h7.simple.data.menu.MenuItem
import org.h7.simple.data.menu.OnMenuClickListener
import org.h7.simple.databinding.ActivityMainBinding
import org.h7.simple.widget.EndDrawerToggle


abstract class MainActivity : AppCompatActivity() {
    abstract fun onMenuItemClick(item: MenuItem):Boolean
    abstract fun getNavViewModel():INavViewModel

    private lateinit var modelNavigation: INavViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        modelNavigation = getNavViewModel()
        binding.footer = modelNavigation.getMenuFooter(this)
        binding.header = modelNavigation.getMenuHeader(this)
        initMenu()
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = EndDrawerToggle(
                this, binding.drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun initMenu() {
        binding.menuItems.adapter = MenuAdapter(modelNavigation.getMenuItems(),object:OnMenuClickListener{
            override fun onMenuItemClick(item: MenuItem) {
                if (this@MainActivity.onMenuItemClick(item))
                    hideMenuIfOpened()
            }

        })
        binding.menuItems.layoutManager = LinearLayoutManager(this)
    }

    override fun onBackPressed() {
        if (!hideMenuIfOpened()){
            super.onBackPressed()
        }
    }

    private fun hideMenuIfOpened():Boolean{
        return if (binding.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            binding.drawerLayout.closeDrawer(GravityCompat.END)
            true
        } else {
            false
        }
    }
}
