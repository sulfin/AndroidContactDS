package fr.isen.tuveny.androidcontactds.model.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
"location": {
        "city": "Besançon",
        "state": "Pas-de-Calais",
        "country": "France",
        "postcode": 74363
        }
 */
@Parcelize
data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Int,
) : Parcelable
