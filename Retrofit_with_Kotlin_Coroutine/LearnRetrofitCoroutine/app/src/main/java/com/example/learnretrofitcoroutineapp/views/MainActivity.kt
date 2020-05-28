package com.example.learnretrofitcoroutineapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.learnretrofitcoroutineapp.R
import com.example.learnretrofitcoroutineapp.models.Albums
import com.example.learnretrofitcoroutineapp.models.AlbumsItem
import com.example.learnretrofitcoroutineapp.networkUtils.AlbumService
import com.example.learnretrofitcoroutineapp.networkUtils.NetworkInstance
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var retroService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retroService = NetworkInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)
        //getRequestWithQueryParameters()
        uploadAlbum()
    }

    private fun getRequestWithQueryParameters(){
        val pathResponse:LiveData<Response<AlbumsItem>> = liveData {
            //val  response = retroService.getAlbumsData()
            val  response2 = retroService.getAlbum(3)
            emit(response2)
        }

        pathResponse.observe(this, Observer {
            val title = it.body()?.title
            Toast.makeText(applicationContext,title,Toast.LENGTH_LONG).show()
        })

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

    private fun uploadAlbum(){
        val album = AlbumsItem(0,"My Title",3)
        val postResponse :LiveData<Response<AlbumsItem>> = liveData{
            val response = retroService.uploadAlbum(album)
            emit(response)
        }

        postResponse.observe(this, Observer {
            val receivedResponse =it.body()
            val result=" "+"Album Title : ${receivedResponse?.title}"+"\n"+
                    " "+"Album id : ${receivedResponse?.id}"+"\n"+
                    " "+"User id : ${receivedResponse?.userId}"+"\n\n\n"
            textView.text =result

        })
    }
}
