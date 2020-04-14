package com.anushka.viewmodeldemo1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    /*fun getCurrentCount():Int{
        return count
    }*/

    /*fun getUpdatedCount():Int{
        return ++count
    }*/

    fun updateCount(){
        count.value =(count.value)?.plus(1)
    }
}