/*
 * project: Simple App, Android
 * app.h7.org/simple/Android
 * Copyright © 2018 H7 (h7.org).
 *
 * created by yatko.com
 */

package org.h7.simple.activity.main.adapter

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.h7.simple.R
import org.h7.simple.data.menu.MenuItem
import org.h7.simple.data.menu.OnMenuClickListener
import org.h7.simple.databinding.MenuItemBinding


/**
 * Created by Alexey Rogovoy (lexapublic@gmail.com) on 29.06.2018.
 */

class MenuAdapter(private var items : List<MenuItem>,private var clickListener: OnMenuClickListener): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<MenuItemBinding>(inflater, R.layout.menu_item, parent, false)
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MenuViewHolder(private var binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuItem){
            binding.item = item
            binding.click = View.OnClickListener { clickListener.onMenuItemClick(item) }
            binding.executePendingBindings()
            binding.icon.setImageResource(item.icon)
        }
    }
}