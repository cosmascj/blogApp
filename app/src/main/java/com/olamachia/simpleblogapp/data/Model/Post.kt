package com.olamachia.simpleblogapp.data.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val userId : Int,
    var id : Int,
    val title : String,
    val body: String
) : Parcelable
