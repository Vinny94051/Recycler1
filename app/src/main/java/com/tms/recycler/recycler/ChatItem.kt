package com.tms.recycler.recycler

import androidx.annotation.DrawableRes
import com.tms.recycler.R

data class ChatItem(
    val title: String,
    val subTitle: String,
    @DrawableRes
    val iconRes: Int = R.drawable.ic_launcher_background
)
