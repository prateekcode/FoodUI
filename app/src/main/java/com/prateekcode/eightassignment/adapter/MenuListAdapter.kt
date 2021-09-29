package com.prateekcode.eightassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prateekcode.eightassignment.R
import com.prateekcode.eightassignment.databinding.MenuSingleItemBinding
import com.prateekcode.eightassignment.model.Menus
import com.squareup.picasso.Picasso

/**
 * Created by Prateek Rai on 29,September,2021
 * Github Profile https://github.com/prateekcode/
 */
class MenuListAdapter(private val menuList: List<Menus>) :
    RecyclerView.Adapter<MenuListAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(private val binding: MenuSingleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menus: Menus) {
            binding.apply {
                Picasso.get().load(menus.itemImage).into(binding.menuItemImageView)
                menuItemTextView.text = menus.itemTitle
                menuSubtitleTextView.text = menus.itemSubtitle
                menuItemPriceTextView.text = menus.itemPrice
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuListAdapter.MenuViewHolder {
        val binding =
            MenuSingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuListAdapter.MenuViewHolder, position: Int) {
        val currentItem = menuList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = menuList.size
}