package com.example.test.publish

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.Article
import com.example.test.data
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.*

class PublishViewModel: ViewModel() {

    private val _mock = MutableLiveData<List<Article>>()

    val mock: LiveData<List<Article>>
        get() = _mock

    private var _articles = MutableLiveData<List<data>>()

    val articles: LiveData<List<data>>
        get() = _articles


    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    init {
        setMockData()
    }

    fun setMockData() {

        var mock = mutableListOf<Article>()
        mock.run {
            add(Article("期中考大地震", "Scolley", "全都沒有畫面", "奇聞", "2200-0412"))
            add(Article("期中考擺爛", "Scolley", "全都沒有畫面", "奇聞", "2200-0412"))
            add(Article("期中考就是要泛舟", "Scolley", "全都沒有畫面", "奇聞", "2200-0412"))
            add(Article("期中考吃肯德基", "Scolley", "全都沒有畫面", "奇聞", "2200-0412"))
            add(Article("期中考吃肯德基", "Scolley", "全都沒有畫面", "奇聞", "2200-0412"))
        }
        _mock.value = mock
    }

    fun addDate() {
        val articles = FirebaseFirestore.getInstance()
            .collection("articles")
            .get()
            .addOnSuccessListener {

                Log.d("test", "_articles.value = ${it.documents}")
                for (document in it) {

                }
            }


//        val data = hashMapOf(
//            "author" to hashMapOf(
//                "email" to "scolley31@gmail.com",
//                "id" to "scolley31",
//                "name" to "Scolley"
//            ),
//            "title" to "test",
//            "content" to "test",
//            "createdTime" to Calendar.getInstance().timeInMillis,
//            "id" to document.id,
//            "category" to "Beauty"
//        )
//        document.set(data)
//        Log.d("test","data = $data")
//    }

    }
}