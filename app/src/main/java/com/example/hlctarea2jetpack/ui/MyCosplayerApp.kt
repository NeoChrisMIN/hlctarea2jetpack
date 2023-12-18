package com.example.hlctarea2jetpack.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.example.hlctarea2jetpack.ui.theme.*

@Composable
fun MyCosplayApp(content: @Composable () -> Unit) {
    MyCosplayTheme() {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}