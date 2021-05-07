package com.example.test.publishDialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class PublishDialogViewModel:ViewModel() {

    val article: MutableMap<String, Any> = HashMap()

    val content = MutableLiveData<String>()

    val title = MutableLiveData<String>()

    val category = MutableLiveData<String>()

    val date = Calendar.getInstance().timeInMillis

}