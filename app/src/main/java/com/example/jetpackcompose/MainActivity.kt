package com.example.jetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("My tag", "Main Coroutines : ${Thread.currentThread().name}")
        }

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("My tag", "Background Coroutines :  ${Thread.currentThread().name}")
        }

    }
}