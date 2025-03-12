package com.vipulasri.jetinstagram.model

// Add this data class at the end of the file
data class Notification(
    val users: List<String>,
    val type: NotificationType,
    val timestamp: String,
    val previewContent: String? = null,
    val isFollow: Boolean = false
)

// Add these sample notifications (before the MainScreen composable)
val notifications = listOf(
    listOf(
        Notification(
            users = listOf("sahalmanzoorsheikh", "bhushan25a"),
            type = NotificationType.STORY_LIKE,
            timestamp = "3h"
        ),
        Notification(
            users = listOf("margaretallen2570561"),
            type = NotificationType.REEL_LIKE,
            timestamp = "20h"
        ),
        Notification(
            users = listOf("mohtashim.shaikhh"),
            type = NotificationType.MENTION,
            timestamp = "21h",
            previewContent = "@mukarrim 💬 Thanks man"
        ),
        Notification(
            users = listOf("itrat_waseem", "mohtashim.shaikhh"),
            type = NotificationType.COMMENT_LIKE,
            timestamp = "21h",
            previewContent = "Vote for my man!"
        )
    ),
    listOf(
        Notification(
            users = listOf("tinathepoet", "awais__butt"),
            type = NotificationType.STORY_LIKE,
            timestamp = "1d"
        )
    ),
    listOf(
        Notification(
            users = listOf("awais__butt"),
            type = NotificationType.COMMENT_LIKE,
            timestamp = "1d",
            previewContent = "@awais__butt nature calls for nature"
        ),
        Notification(
            users = listOf("sundusholic"),
            type = NotificationType.MENTION,
            timestamp = "2d",
            previewContent = "@mukarrim thank you"
        ),
        Notification(
            users = listOf("sundusholic"),
            type = NotificationType.COMMENT_LIKE,
            timestamp = "2d",
            previewContent = "Congratulations"
        ),
        Notification(
            users = listOf("madhan.gangadhari"),
            type = NotificationType.FOLLOW,
            timestamp = "3d",
            isFollow = true
        )
    )
)