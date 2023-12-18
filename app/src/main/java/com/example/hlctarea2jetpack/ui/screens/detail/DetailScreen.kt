package com.example.hlctarea2jetpack.ui.screens.detail


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.hlctarea2jetpack.model.getMedia
import com.example.hlctarea2jetpack.ui.screens.shared.ArrowBackIcon
import com.example.hlctarea2jetpack.ui.screens.shared.Thumb

@Composable
fun DetailScreen(mediaId: Int, onUpClick: () -> Unit) {
    val mediaItem = remember { getMedia().first { it.id == mediaId } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick) },
                backgroundColor = Color.Green
            )
        }
    ) {
        //Thumb(mediaItem = mediaItem)
        Column(
            modifier = Modifier.fillMaxSize(),
            content = {
                Thumb(mediaItem = mediaItem,
                    modifier = Modifier
                        .size(400.dp)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
                Text(
                    text = "Descripción: ${mediaItem.description}",
                    modifier = Modifier
                        .padding(16.dp)
                        .background(
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp)
                        ,
                    color = Color.White
                )
            }
        )
    }
}