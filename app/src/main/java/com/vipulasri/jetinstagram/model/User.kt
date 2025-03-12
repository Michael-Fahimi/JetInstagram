package com.vipulasri.jetinstagram.model

data class User(
    val name: String,
    val username: String,
    val image: String,
    val bio: String = "" // Add bio field
)
