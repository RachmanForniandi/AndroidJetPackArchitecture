package com.example.basicrecyclerviewkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val fruitsListData = listOf(FruitDealer("Mangga","Tom"), FruitDealer("Apel","Joe"),
        FruitDealer("Pisang","Mark") , FruitDealer("Jambu","Mike"),
        FruitDealer("Lemon","Mike"),
        FruitDealer("Buah Pir","Frank"), FruitDealer("Jeruk","Joe"), FruitDealer
    ("Alpukat","Yanto"), FruitDealer("Buah Naga","Budiyanto")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_item.setBackgroundColor(Color.YELLOW)
        list_item.layoutManager = LinearLayoutManager(this)
        list_item.adapter = SimpleAdapter(fruitsListData,{selectedItem:FruitDealer->itemClicked(selectedItem)})
    }

    private fun itemClicked(selectedItem: FruitDealer) {
        Toast.makeText(this,"Penyedia buah ini adalah ${selectedItem.supplier}",Toast.LENGTH_LONG).show()
    }
}
