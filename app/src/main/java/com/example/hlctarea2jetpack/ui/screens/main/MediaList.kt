package com.example.hlctarea2jetpack.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview

import com.example.hlctarea2jetpack.model.MediaItem
import com.example.hlctarea2jetpack.model.getMedia
import com.example.hlctarea2jetpack.ui.MyCosplayApp
import com.example.hlctarea2jetpack.ui.screens.shared.Thumb

import com.example.hlctarea2jetpack.R

@ExperimentalFoundationApi
@Composable
fun MediaList(
    onClick: (MediaItem) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_width)),
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        modifier = modifier
    ) {
        items(getMedia()) {
            MediaListItem(
                mediaItem = it,
                onClick = { onClick(it) },
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall))
            )
        }
    }
}

@Composable
fun MediaListItem(
    mediaItem: MediaItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable { onClick() }
    ) {
        Column {
            Thumb(mediaItem)
            Title(mediaItem)
        }
    }
}

@Composable
private fun Title(mediaItem: MediaItem) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            //.background(MaterialTheme.colors.secondary)
            .background(Color.Green)
            .padding(dimensionResource(R.dimen.padding_medium))
    ) {
        Text(
            text = mediaItem.title,
            style = MaterialTheme.typography.h6
        )
    }
}

@Preview
@Composable
fun MediaListItemPreview() {
    MyCosplayApp {
        val mediaItem = MediaItem(1, "Item 1", "", MediaItem.Type.VIDEO, "")
        MediaListItem(mediaItem = mediaItem, onClick = {})
    }
}