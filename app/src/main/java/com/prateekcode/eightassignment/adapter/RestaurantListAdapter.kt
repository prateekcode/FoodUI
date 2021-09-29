package com.prateekcode.eightassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prateekcode.eightassignment.R
import com.prateekcode.eightassignment.databinding.RestaurantSingleItemBinding
import com.prateekcode.eightassignment.model.Restaurants
import com.squareup.picasso.Picasso

/**
 * Created by Prateek Rai on 29,September,2021
 * Github Profile https://github.com/prateekcode/
 */
class RestaurantListAdapter(private val restaurantList: List<Restaurants>) :
    RecyclerView.Adapter<RestaurantListAdapter.RestaurantViewHolder>() {

    inner class RestaurantViewHolder(private val binding: RestaurantSingleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurants: Restaurants) {
            binding.apply {
                Picasso.get().load(restaurants.restaurantImg).error(R.drawable.dummy_food_img)
                    .into(binding.restaurantImageView)
                restaurantNameTextView.text = restaurants.restaurantName
                timeLocatedTextView.text = restaurants.restaurantMinTimeToReach
            }
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantListAdapter.RestaurantViewHolder {
        val binding =
            RestaurantSingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RestaurantListAdapter.RestaurantViewHolder,
        position: Int
    ) {
        val currentItem = restaurantList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = restaurantList.size
}
