package com.olamachia.simpleblogapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.olamachia.simpleblogapp.data.Model.Post
import com.olamachia.simpleblogapp.data.Model.Repository

 class CommentPageViewModelFactory(private val post: Post, private val repository: Repository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CommentPageViewModel(post,repository) as T
    }
}