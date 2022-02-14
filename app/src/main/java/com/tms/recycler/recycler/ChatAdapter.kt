package com.tms.recycler.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tms.recycler.recycler.clickListener.OnChatItemClick

class ChatAdapter(
    private val onChatItemClick: OnChatItemClick
): RecyclerView.Adapter<ChatViewHolder>() {

    private var items: List<ChatItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder.newInstance(parent, onChatItemClick)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitList(data: List<ChatItem>) {
        items = data
        notifyDataSetChanged()
    }
}