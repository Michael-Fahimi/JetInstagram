package com.vipulasri.jetinstagram.ui.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.model.Notification
import com.vipulasri.jetinstagram.model.NotificationType
import com.vipulasri.jetinstagram.model.notifications

@Composable
fun NotificationsScreen() {
    val sections = listOf("Today", "Yesterday", "This week")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        notifications.forEachIndexed { index, sectionNotifications ->
            val sectionTitle = sections[index]

//            stickyHeader {
//                SectionHeader(title = sectionTitle)
//            }

            itemsIndexed(sectionNotifications) { itemIndex, notification ->
                NotificationItem(notification = notification)
                if (itemIndex < sectionNotifications.lastIndex) {
                    Divider(
                        modifier = Modifier.padding(start = 60.dp, end = 16.dp),
                        color = Color.LightGray.copy(alpha = 0.3f)
                    )
                }
            }
        }
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.onBackground
    )
}

@Composable
private fun NotificationItem(notification: Notification) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image
        Image(
            painter = rememberImagePainter(
                data = "https://picsum.photos/50?random=${notification.users.first()}",
                builder = { placeholder(R.drawable.ic_outlined_favorite) }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Notification Text
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = buildNotificationText(notification),
                style = MaterialTheme.typography.body2.copy(
                    color = MaterialTheme.colors.onBackground
                )
            )

            Text(
                text = notification.timestamp,
                style = MaterialTheme.typography.caption.copy(
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            )

            notification.previewContent?.let { content ->
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = content,
                    style = MaterialTheme.typography.body2.copy(
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                )
            }
        }

        // Action Button/Preview
        if (notification.isFollow) {
            TextButton(
                onClick = { /* Handle follow */ },
                modifier = Modifier
                    .border(1.dp, Color.LightGray, CircleShape)
                    .padding(horizontal = 16.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Follow",
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Composable
private fun buildNotificationText(notification: Notification): String {
    return buildAnnotatedString {
        // User names
        notification.users.forEachIndexed { index, user ->
            withStyle(style = MaterialTheme.typography.body2.toSpanStyle().copy(
                fontWeight = FontWeight.Bold
            )) {
                append(user)
            }
            if (index < notification.users.lastIndex - 1) append(", ")
            if (index == notification.users.lastIndex - 1) append(" and ")
        }

        // Action text
        append(" ")
        append(when (notification.type) {
            NotificationType.STORY_LIKE -> "liked your story"
            NotificationType.REEL_LIKE -> "liked your reel"
            NotificationType.MENTION -> "mentioned you in a comment:"
            NotificationType.COMMENT_LIKE -> "liked your comment:"
            NotificationType.FOLLOW -> "started following you"
        })
    }.toString()
}