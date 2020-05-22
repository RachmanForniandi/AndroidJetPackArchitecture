package com.anushka.viewmodelscopedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anushka.viewmodelscopedemo.model.User
import com.anushka.viewmodelscopedemo.repository.UserRepository
import kotlinx.coroutines.*


class MainActivityViewModel : ViewModel() {

    private var userRepository = UserRepository()
    var users :MutableLiveData<List<User>> = MutableLiveData()
    private val myJob = Job()
/*private val myScope = CoroutineScope(Dispatchers.IO + myJob)*/

 fun getUserData(){

     viewModelScope.launch {
         //write some code
         var result: List<User>? = null
         withContext(Dispatchers.IO){
             result = userRepository.getUser()
         }

         users.value = result
     }
 }

    override fun onCleared() {
        super.onCleared()
        myJob.cancel()

    }


}