package com.example.learnroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnroom.R
import com.example.learnroom.adapter.DataAdapter
import com.example.learnroom.databinding.ActivityMainBinding
import com.example.learnroom.dbModel.Subscriber
import com.example.learnroom.dbModel.SubscriberDatabase
import com.example.learnroom.localRepository.SubscriberRepository
import com.example.learnroom.viewModel.SubscriberViewModel
import com.example.learnroom.viewModel.SubscriberViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this,factory).get(SubscriberViewModel::class.java)

        mBinding.localViewModel = subscriberViewModel
        mBinding.lifecycleOwner = this

        initRoomDataLocal()
        subscriberViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled().let {
                Toast.makeText(this,it,Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initRoomDataLocal() {
        mBinding.subscriberRecyclerView.layoutManager = LinearLayoutManager(this)
        showSubscribersList()
    }


    private fun showSubscribersList(){
        subscriberViewModel.subscriber.observe(this, Observer {
            Log.i("MYTAG",it.toString())
            mBinding.subscriberRecyclerView.adapter = DataAdapter(it,{selectedItem:Subscriber->listItemClick(selectedItem)})
        })
    }

    private fun listItemClick(subscriber:Subscriber){
        Toast.makeText(this,"Selected name is ${subscriber.name}",Toast.LENGTH_LONG).show()
        subscriberViewModel.initUpdateAndDelete(subscriber)
    }


}
