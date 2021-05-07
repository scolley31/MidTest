package com.example.test

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class fireBaseData(

    val articles: HashMap<String,data>,

) : Parcelable

@Parcelize
data class data(

    val author: HashMap<String,String>,
    val createdTime: String?,
    val id: Int,
    val title: String?,
    val category: String?,
    val content: String?

) : Parcelable

@Parcelize
data class Article(

    val title: String?,
    val author: String?,
    val content: String?,
    val category: String?,
    val createdTime: String?,

) : Parcelable