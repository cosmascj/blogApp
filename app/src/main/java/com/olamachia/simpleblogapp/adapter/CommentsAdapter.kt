package com.olamachia.simpleblogapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.olamachia.simpleblogapp.R
import com.olamachia.simpleblogapp.data.Model.Comment


class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    private val comments = mutableListOf<Comment>()

    /**
     * Called when RecyclerView needs a new RecyclerView.ViewHolder
     * of the given type to represent an item
     */
    inner class CommentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.commentName)
        val body: TextView = itemView.findViewById(R.id.commentBody)
    }

    /**
     * Inflates the xml layout which makes up each item on the recyclerView
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val rootView =
            LayoutInflater.from(parent.context).inflate(R.layout.comment_list_view, parent, false)
        return CommentsViewHolder(rootView)
    }

    /**
     * Called by RecyclerView to display the data at the specified position
     */
    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.title.text = comments[position].name
        holder.body.text = comments[position].body
    }

    /**
     * Returns the total number of items in the data set held by the adapter
     */
    override fun getItemCount(): Int {
        return comments.size
    }

    /**
     * Gets the lists of comments from the server
     * and populates the list in the adapter before been
     * loaded on the recyclerview
     */
    fun loadComments(list: List<Comment>) {
        comments.addAll(list)
    }

    /**
     * Gets the comment from the users input and
     * adds it to the list of comments in the
     * recyclerView adapter and updates the list
     * on the screen
     */
    fun addCustomComment(newComment: Comment) {
        comments.add(newComment)
        notifyDataSetChanged()
    }

}