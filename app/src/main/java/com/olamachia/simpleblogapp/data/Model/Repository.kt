package com.olamachia.simpleblogapp.data.Model


import com.olamachia.simpleblogapp.data.network.RetrofitInstance
import retrofit2.Response


/**
 * In this class there will be suspend functions used by the coroutines to complete asynchronous processes
 * */

class Repository {

    suspend fun getPosts() : Response<List<Post>> {
        return RetrofitInstance.api.getPosts()
    }

    suspend fun getComments(postId : Int) : Response<List<Comment>> {
        return RetrofitInstance.api.getComments(postId)
    }

    suspend fun pushPost(post: Post) : Response<Post> {
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun poshComment(comment: Comment) : Response<Comment>{
        return RetrofitInstance.api.pushComment(comment)
    }
}