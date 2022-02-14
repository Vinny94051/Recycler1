package com.tms.recycler.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.tms.recycler.R
import com.tms.recycler.recycler.clickListener.OnChatItemClick

class ChatViewHolder(
    itemView: View,
    val onItemClickListener: OnChatItemClick
) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun newInstance(
            parent: ViewGroup,
            onItemClickListener: OnChatItemClick
        ) = ChatViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_chat,
                    parent,
                    false
                ),
            onItemClickListener = onItemClickListener
        )
    }

    private val titleTextView by lazy {
        itemView.findViewById<TextView>(R.id.title)
    }

    private val subtitleTextView by lazy {
        itemView.findViewById<TextView>(R.id.subtitle)
    }

    private val iconView by lazy {
        itemView.findViewById<ImageView>(R.id.icon)
    }

    private val rootView by lazy {
        itemView.findViewById<ConstraintLayout>(R.id.root)
    }

    fun bindItem(item: ChatItem) {

        with(item) {
            titleTextView.text = title
            subtitleTextView.text = subTitle
            iconView.setImageResource(iconRes)
        }

        rootView.setOnClickListener {
            onItemClickListener.onItemClick(item)
        }
    }

}
