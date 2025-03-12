package com.vipulasri.jetinstagram.model

data class Post(
  val id: Int,
  val image: String,
  val user: User,
  val isLiked: Boolean = false,
  val likesCount: Int,
  val commentsCount: Int,
  val timeStamp: Long
)

data class Story(
  val image: String,
  val name: String,
  val isSeen: Boolean = false
)

val currentUser = User(
    name = "JennHerman",
    username = "JennHerman",
    image = "https://randomuser.me/api/portraits/women/30.jpg" // Replace with actual image URL
)

val names = arrayOf(
    "storee",
    "nianyc",
    "opioke",
    "ashoke",
    "dark_emarlds",
    "bedtan",
    "shrish",
    "matdo",
    "phillsohn",
    "deitch"
)

