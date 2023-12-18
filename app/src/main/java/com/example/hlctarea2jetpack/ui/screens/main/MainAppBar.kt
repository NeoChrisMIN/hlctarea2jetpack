package com.example.hlctarea2jetpack.ui.screens.main


import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

import com.example.hlctarea2jetpack.R
import com.example.hlctarea2jetpack.ui.MyCosplayApp

@Composable
fun MainAppBar() {
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name)) },
        actions = {
            AppBarAction(
                imageVector = Icons.Default.Search,
                onClick = { /* TODO */ }
            )
            AppBarAction(
                imageVector = Icons.Default.Settings,
                onClick = { /* TODO */ }
            )
            AppBarAction(
                imageVector = Icons.Default.Home,
                onClick = { /* TODO */ }
            )
        }
    )
}

@Composable
private fun AppBarAction(
    imageVector: ImageVector,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun AppBarActionPreview() {
    MyCosplayApp {
        MainAppBar()
    }
}