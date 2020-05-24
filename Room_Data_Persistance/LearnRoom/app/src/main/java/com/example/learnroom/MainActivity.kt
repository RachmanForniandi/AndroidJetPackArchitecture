package com.example.learnroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.learnroom.databinding.ActivityMainBinding
import com.example.learnroom.dbModel.SubscriberDatabase
import com.example.learnroom.localRepository.SubscriberRepository
import com.example.learnroom.viewModel.SubscriberViewModel
import com.example.learnroom.viewModel.SubscriberViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this,factory).get(SubscriberViewModel::class.java)

        mBinding.localViewModel = subscriberViewModel
        mBinding.lifecycleOwner = this
        showSubscribersList()


    }

    private fun showSubscribersList(){
        subscriberViewModel.subscriber.observe(this, Observer {
            Log.i("MYTAG",it.toString())
        })
    }
}
