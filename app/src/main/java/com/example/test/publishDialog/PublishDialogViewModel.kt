package com.example.test.publishDialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class PublishDialogViewModel:ViewModel() {

    val author: MutableMap<String, Any> = HashMap()

    val content= MutableLiveData<String>()

    val date = Date()

}