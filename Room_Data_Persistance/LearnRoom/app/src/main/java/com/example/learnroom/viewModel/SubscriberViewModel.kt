package com.example.learnroom.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Delete
import com.example.learnroom.dbModel.Subscriber
import com.example.learnroom.localRepository.SubscriberRepository
import com.example.learnroom.utility.Event
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(), Observable {

    val subscriber = repository.subscribers
    private var isUpdateOrDelete = false
    private lateinit var subscriberToUpdateOrDelete: Subscriber

    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearAllOrDeleteButtonText = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()

    val message : LiveData<Event<String>>
    get() = statusMessage

    init {
        saveOrUpdateButtonText.value = "Save"
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate(){
        if (isUpdateOrDelete){
            subscriberToUpdateOrDelete.name = inputName.value.toString()
            subscriberToUpdateOrDelete.email = inputEmail.value.toString()
            update(subscriberToUpdateOrDelete)
        }else{
            val name = inputName.value
            val email = inputEmail.value
            insert(Subscriber(0, name.toString(), email.toString()))
            inputName.value =null
            inputEmail.value =null
        }
    }

    fun clearAllOrDelete(){
        if (isUpdateOrDelete){
            delete(subscriberToUpdateOrDelete)
        }else{
            clearAll()
        }
    }

    fun insert(subscriber: Subscriber) = viewModelScope.launch {
        val newRowId:Long = repository.insert(subscriber)
        if (newRowId > -1){
            statusMessage.value = Event("Subscriber Inserted Successfully $newRowId")
        }else{
            statusMessage.value = Event("Error Occured")
        }

    }

    fun update(subscriber: Subscriber) = viewModelScope.launch {
        val noOfRows =repository.update(subscriber)
        if (noOfRows>0){
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("$noOfRows Subscriber Updated Successfully")
        }else{
            statusMessage.value = Event("Error Occured")
        }

    }

    fun delete(subscriber: Subscriber) = viewModelScope.launch {
        val noOfRowsDeleted =repository.delete(subscriber)
        if (noOfRowsDeleted > 0){
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearAllOrDeleteButtonText.value = "Clear All"
            statusMessage.value = Event("$noOfRowsDeleted Row Deleted Successfully")
        }else{
            statusMessage.value = Event("Error Occured")
        }

    }

    fun clearAll() = viewModelScope.launch {
        val noOfRowsDeleted = repository.deleteAll()
        if (noOfRowsDeleted > 0) {
            statusMessage.value = Event("$noOfRowsDeleted Deleted Successfully")
        } else{
            statusMessage.value = Event("Error Occured")
        }
    }

    fun initUpdateAndDelete(subscriber: Subscriber){
        inputName.value = subscriber.name
        inputEmail.value = subscriber.email
        isUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriber
        saveOrUpdateButtonText.value = "Update"
        clearAllOrDeleteButtonText.value = "Delete"
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}