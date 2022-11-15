package com.example.jetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompose.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //Instance of our view model
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        viewModel.count.observe(this) {
            binding.countText.text = it.toString()
        }
        binding.button.setOnClickListener {
            viewModel.updateCount()
        }
    }
}