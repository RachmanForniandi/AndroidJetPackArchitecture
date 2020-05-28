package com.example.learnretrofitcoroutineapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.learnretrofitcoroutineapp.R
import com.example.learnretrofitcoroutineapp.models.Albums
import com.example.learnretrofitcoroutineapp.networkUtils.AlbumService
import com.example.learnretrofitcoroutineapp.networkUtils.NetworkInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retroService = NetworkInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData:LiveData<Response<Albums>> = liveData {
            //val  response = retroService.getAlbumsData()
            val  response = retroService.getSortedAlbumsData(3)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumList =it.body()?.listIterator()
            if (albumList != null){
                while (albumList.hasNext()){
                    val albumsItem = albumList.next()
                    Log.i("MYTAG",albumsItem.title)
                    val result=" "+"Album Title : ${albumsItem.title}"+"\n"+
                                    " "+"Album id : ${albumsItem.id}"+"\n"+
                                    " "+"User id : ${albumsItem.userId}"+"\n\n\n"
                    textView.append(result)
                }
            }
        })
    }
}
