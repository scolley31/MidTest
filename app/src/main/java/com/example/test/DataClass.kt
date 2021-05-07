package com.example.test

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Author(
    val author: String?,
    val article: List<Article?>
) : Parcelable

@Parcelize
data class Article(

    val title: String?,
    val author: String?,
    val content: String?,
    val category: String?,
    val createdTime: String?,

) : Parcelable