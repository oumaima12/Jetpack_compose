package com.example.jetpackcompose

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val fruitList = listOf(Fruit("mango", "ouma"),
                           Fruit("apple", "oumaima"),
                           Fruit("banana", "oumi"),
                           Fruit("pear", "joe"),
                           Fruit("orange", "sandy"),
                           Fruit("strawberry", "josé"),
                           Fruit("lemon", "Oumaima"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecycleViewAdapter(fruitList) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(this, "Supplier Fruit is : ${fruit.supplier}", Toast.LENGTH_LONG).show()
    }
}