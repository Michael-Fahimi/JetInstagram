package com.vipulasri.jetinstagram.ui.profile


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.model.currentUser

@ExperimentalFoundationApi
@Composable
fun ProfilePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        // Header Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Profile Image
            Image(
                painter = rememberImagePainter(currentUser.image),
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Stats
            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ProfileStat(number = "153", label = "Posts")
                ProfileStat(number = "30", label = "Followers")
                ProfileStat(number = "48", label = "Following")
            }
        }

        // Bio Section
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = currentUser.name, fontSize = 14.sp)
            Text(
                text = "Putting my best foot forward - in heels everyday.\n\n" +
                        "These are my random musings as a single mom and entrepreneur",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }

        // Edit Profile Button
        Button(
            onClick = { /* Handle edit profile */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.LightGray,
                contentColor = Color.Black
            ),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            Text(text = "Edit Profile", fontSize = 12.sp)
        }

        // Tabs
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            TabItem("Posts", isSelected = true)
            TabItem("Reels", isSelected = false)
        }

        // Posts Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            items(9) {
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .padding(1.dp)
                        .background(Color.Gray)
                )
            }
        }
    }
}

@Composable
private fun ProfileStat(number: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = number, fontSize = 14.sp)
        Text(text = label, fontSize = 12.sp, color = Color.Gray)
    }
}

@Composable
private fun TabItem(text: String, isSelected: Boolean) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = if (isSelected) Color.Black else Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        if (isSelected) {
            Divider(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .height(1.dp),
                color = Color.Black
            )
        }
    }
}