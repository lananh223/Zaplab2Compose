package com.practice.zaplab2compose.model

import androidx.annotation.StringRes

data class PhotoData(
    val url: String,
    @StringRes val id: Int,
     val title: String,
)
