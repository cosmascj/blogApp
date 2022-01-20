package com.olamachia.simpleblogapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.olamachia.simpleblogapp.Util.ItemViewClickListener
import com.olamachia.simpleblogapp.data.Model.Post

import com.olamachia.simpleblogapp.R

class PostAdapter(val itemClickListener: ItemViewClickListener) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private val postList = mutableListOf<Post>()
    private val listToBeDisplayed = mutableListOf<Post>()
    private var filteredPostList = mutableListOf<Post>()

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder
     * of the given type to represent an item
     */
    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        lateinit var post: Post
        var title: TextView = itemView.findViewById(R.id.postTitle)
        var body: TextView = itemView.findViewById(R.id.postBody)
        override fun onClick(v: View?) {
            itemClickListener.onClickListener(adapterPosition, v!!, post)
        }

        init {
            itemView.setOnClickListener(this)
        }

        /**
         * Binds the viewHolder to the various views
         */
        fun bind(post: Post) {
            this.post = post
            this.title.text = post.title
            this.body.text = post.body
        }
    }

    /**
     * Inflates the xml layout which makes up each item on the recyclerView
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item_view, parent, false)
        return PostViewHolder(view)
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     */
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = listToBeDisplayed[position]
        holder.bind(post)

    }

    /**
     * Returns the total number of items in the data set held by the adapter
     */
    override fun getItemCount(): Int {
        return listToBeDisplayed.size
    }

    /**
     * This method is called to load the primary
     * [MutableList<Post>()]
     */
    fun loadPostList(list: List<Post>) {
        postList.addAll(list)
        notifyDataSetChanged()
    }

    /**
     * This method is called to load the secondary
     * [MutableList<Post>()] to enable filtering
     */
    fun reloadPostList(list: List<Post>) {
        listToBeDisplayed.clear()
        listToBeDisplayed.addAll(list)
        notifyDataSetChanged()
    }

    /**
     * Invoked to all the user add a new post
     */
    fun addCustomPost(post: Post) {
        listToBeDisplayed.add(0, post)
        notifyDataSetChanged()
    }

    /**
     * Invoked to load the filtered post to the recyclerView
     */
    fun loadFilteredPosts(userId: Int) {
        filteredPostList = postList.filter {
            it.userId == userId
        } as MutableList<Post>
        reloadPostList(filteredPostList)
        notifyDataSetChanged()
    }

}