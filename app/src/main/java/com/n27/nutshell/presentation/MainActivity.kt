package com.n27.nutshell.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.n27.nutshell.NutshellApplication
import com.n27.nutshell.databinding.ActivityMainBinding
import com.n27.nutshell.di.AppComponent

class MainActivity : AppCompatActivity() {

    lateinit var appComponent: AppComponent

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = (applicationContext as NutshellApplication).appComponent
        appComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}