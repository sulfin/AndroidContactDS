package fr.isen.tuveny.androidcontactds.model.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
"name": {
        "title": "Mr",
        "first": "Timothe",
        "last": "Charles"
      }
 */
@Parcelize
data class Name(
    val title: String,
    val first: String,
    val last: String,
) : Parcelable
