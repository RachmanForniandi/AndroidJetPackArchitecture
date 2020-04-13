package com.example.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding:ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory = MainActivityModelFactory(125)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)
        mainBinding.tvResult.text = viewModel.getTotal().toString()

        mainBinding.btnInsert.setOnClickListener {
            viewModel.setTotal(mainBinding.etInput.text.toString().toInt())
            mainBinding.tvResult.text = viewModel.getTotal().toString()
        }
    }
}
