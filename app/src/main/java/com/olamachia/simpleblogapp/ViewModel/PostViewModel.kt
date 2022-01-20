package com.olamachia.simpleblogapp.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olamachia.simpleblogapp.data.Model.Post
import com.olamachia.simpleblogapp.data.Model.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class PostViewModel(private val repository: Repository) : ViewModel() {
    private var _postList = MutableLiveData<Response<List<Post>>>()
    val postList : MutableLiveData<Response<List<Post>>>
        get() = _postList

    private var _post = MutableLiveData<Response<Post>>()
    val post : MutableLiveData<Response<Post>>
        get() = _post

    init {
        getPosts()
    }

    /**
     * Invoked to get the list of posts from the server
     */
    private fun getPosts(){
        viewModelScope.launch {
            val response : Response<List<Post>> = repository.getPosts()
            _postList.value = response

        }
    }

    /**
     * called when adding a new post to the data
     * source and to the endpoint as well
     */
    fun pushPost(newPost: Post) {
        viewModelScope.launch {
            val response = repository.pushPost(newPost)
            _post.value = response
        }
    }
}