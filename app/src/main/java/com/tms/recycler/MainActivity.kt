package com.tms.recycler

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.tms.recycler.recycler.ChatAdapter
import com.tms.recycler.recycler.ChatItem
import com.tms.recycler.recycler.clickListener.OnChatItemClick

class MainActivity : AppCompatActivity() {

    private val adapter by lazy {
        ChatAdapter(
            onChatItemClick
        )
    }
    
    private val recycler by lazy { findViewById<RecyclerView>(R.id.recycler) }

    private val onChatItemClick by lazy {
        object : OnChatItemClick {
            override fun onItemClick(item: ChatItem) {
                Toast.makeText(
                    this@MainActivity,
                    item.title, Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        recycler.adapter = adapter

        adapter.submitList(
           Storage.list
        )
    }

}

object Storage {
    val list =  listOf(
        ChatItem(
            title = "title1",
            subTitle = "subtitle1"
        ),
        ChatItem(
            title = "title2",
            subTitle = "subtitle2"
        ),
        ChatItem(
            title = "title3",
            subTitle = "subtitle3"
        ),
        ChatItem(
            title = "title4",
            subTitle = "subtitle4"
        ),
        ChatItem(
            title = "title5",
            subTitle = "subtitle5"
        ),
        ChatItem(
            title = "title5",
            subTitle = "subtitle5"
        )
    )
}
