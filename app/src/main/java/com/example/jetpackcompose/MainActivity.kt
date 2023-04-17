package com.example.jetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpackcompose.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main )
        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main){
                binding.tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
           // Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}