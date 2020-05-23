package com.example.learnroom.localRepository

import com.example.learnroom.dbModel.Subscriber
import com.example.learnroom.dbModel.SubscriberDAO

class SubscriberRepository(private val dao:SubscriberDAO) {

    val subscribers = dao.getAllSubscribers()

    suspend fun insert(subscriber: Subscriber){
        dao.insertSubscriber(subscriber)
    }

    suspend fun update(subscriber: Subscriber){
        dao.updateSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber){
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}