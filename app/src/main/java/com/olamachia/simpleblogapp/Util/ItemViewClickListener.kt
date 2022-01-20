package com.olamachia.simpleblogapp.Util

import android.view.View
import com.olamachia.simpleblogapp.data.Model.Post
/**
 *This is the listner for each of the recycler view item
 * */
interface ItemViewClickListener {
    fun onClickListener(position:Int, view: View, post: Post)
}