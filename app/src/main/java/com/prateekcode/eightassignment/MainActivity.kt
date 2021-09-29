package com.prateekcode.eightassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.prateekcode.eightassignment.databinding.ActivityMainBinding
import github.com.st235.lib_expandablebottombar.navigation.ExpandableBottomBarNavigationUI

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigationController = Navigation.findNavController(this, R.id.fragment_container)
        binding.apply {
            ExpandableBottomBarNavigationUI.setupWithNavController(
                expandableBottomBar,
                navigationController
            )
        }
    }
}