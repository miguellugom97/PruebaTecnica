package com.miguellugo.pruebatecnica.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.miguellugo.pruebatecnica.R
import com.miguellugo.pruebatecnica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private val binding: ActivityMainBinding by viewBinding()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation()
        setup()
    }

    private fun setup()
    {

    }

    private fun navigation()
    {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)
    }
}