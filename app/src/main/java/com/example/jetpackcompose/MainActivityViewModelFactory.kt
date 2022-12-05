package com.example.jetpackcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory(private val startingTotal: Int) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startingTotal) as T
        }
        throw java.lang.IllegalArgumentException("Unknown view modal class")
    }
}