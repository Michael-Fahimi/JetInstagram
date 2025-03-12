package com.vipulasri.jetinstagram.model


// Modified Profile Data class
data class ProfileData(
    val user: User,
    val bio: String,
    val postsCount: Int,
    val followersCount: String,
    val followingCount: Int,
    val isCurrentUser: Boolean = false
)

// Sample data using your existing models
val sampleProfileData = ProfileData(
    user = currentUser,
    bio = "Android Developer Love coding and design",
    postsCount = 142,
    followersCount = "12.5K",
    followingCount = 342,
    isCurrentUser = true
)

val samplePosts = List(12) {
    Post(
        id = it,
        image = "https://picsum.photos/300/300?random=$it",
        user = currentUser,
        isLiked = false,
        likesCount = 0,
        commentsCount = 0,
        timeStamp = System.currentTimeMillis()
    )
}