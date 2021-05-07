package com.example.test.publish

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.Article
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class PublishViewModel: ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()

    val articles: LiveData<List<Article>>
        get() = _articles

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    init {
        setMockData()
    }

    fun setMockData(){

        var mock = mutableListOf<Article>()
        mock.run {
            add(Article("期中考大地震","Scolley","全都沒有畫面","奇聞","2200-0412"))
            add(Article("期中考擺爛","Scolley","全都沒有畫面","奇聞","2200-0412"))
            add(Article("期中考就是要泛舟","Scolley","全都沒有畫面","奇聞","2200-0412"))
            add(Article("期中考吃肯德基","Scolley","全都沒有畫面","奇聞","2200-0412"))
        }
        _articles.value = mock
    }

    fun addDate() {
        val articles = FirebaseFirestore.getInstance()
            .collection("articles")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        Log.d("ADD", document.id + " => " + document.data)
                    }
                } else {
                    Log.w("ADD", "Error getting documents.", task.exception)
                }
            }
    }

}