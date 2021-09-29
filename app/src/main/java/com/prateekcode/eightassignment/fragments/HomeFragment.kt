package com.prateekcode.eightassignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.prateekcode.eightassignment.adapter.MenuListAdapter
import com.prateekcode.eightassignment.adapter.RestaurantListAdapter
import com.prateekcode.eightassignment.databinding.FragmentHomeBinding
import com.prateekcode.eightassignment.model.Menus
import com.prateekcode.eightassignment.model.Restaurants


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val restaurantList = ArrayList<Restaurants>()
        restaurantList.add(Restaurants(imageBaseUrl(2104568), "Vegan Restro", "12 Mins"))
        restaurantList.add(Restaurants(imageBaseUrl(2104558), "Healthy Food", "8 Mins"))
        restaurantList.add(Restaurants(imageBaseUrl(958545), "Good Food", "15 Mins"))
        restaurantList.add(Restaurants(imageBaseUrl(941861), "Smart Restro", "10 Mins"))
        restaurantList.add(Restaurants(imageBaseUrl(958545), "Punjabi Dhaba", "5 Mins"))


        val menuItemList = ArrayList<Menus>()
        menuItemList.add(
            Menus(
                imageBaseUrl(842571),
                "Green Noodle",
                "Pure Veg",
                "$8"
            )
        )
        menuItemList.add(
            Menus(
                imageBaseUrl(2097090),
                "Herbal Pancake",
                "Warung Herbal",
                "$14"
            )
        )
        menuItemList.add(
            Menus(
                imageBaseUrl(1260968),
                "Fruit Salad",
                "Wijji Restro",
                "$12"
            )
        )
        menuItemList.add(
            Menus(
                imageBaseUrl(1583884),
                "Green Noodle",
                "Noodle Home",
                "$8"
            )
        )
        menuItemList.add(
            Menus(
                imageBaseUrl(2641886),
                "Maggie",
                "Pure Veg",
                "$14"
            )
        )

        binding.apply {
            restaurantRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                adapter = RestaurantListAdapter(restaurantList)
            }
            menuRecyclerView.apply {
                layoutManager =
                    LinearLayoutManager(requireContext())
                adapter = MenuListAdapter(menuItemList)
            }
        }

    }

    private fun imageBaseUrl(imageId: Long) =
        "https://images.pexels.com/photos/${imageId}/pexels-photo-${imageId}.jpeg?auto=compress&cs=tinysrgb&w=640&h=960&dpr=1"

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}