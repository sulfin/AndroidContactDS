package fr.isen.tuveny.androidcontactds.model.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
"picture": {
        "large": "https://randomuser.me/api/portraits/men/48.jpg",
        "medium": "https://randomuser.me/api/portraits/med/men/48.jpg",
        "thumbnail": "https://randomuser.me/api/portraits/thumb/men/48.jpg"
      }
 */
@Parcelize
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String,
) : Parcelable
