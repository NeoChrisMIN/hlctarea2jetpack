package com.example.hlctarea2jetpack.model


import com.example.hlctarea2jetpack.model.MediaItem.Type

data class MediaItem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type,
    val description: String
) {
    enum class Type { PHOTO, VIDEO }
}

fun getMedia() = (1..10).map {
    MediaItem(
        id = it,
        title = "Cosplayer $it",
        thumb = "https://loremflickr.com/400/400/cosplay?lock=$it",
        type = if (it % 3 == 0) Type.VIDEO else Type.PHOTO,
        description = "\nEsta persona es el cosplayer $it y es el numero $it de la lista de cosplayers"
    )
}