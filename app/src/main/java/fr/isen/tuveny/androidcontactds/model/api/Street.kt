package fr.isen.tuveny.androidcontactds.model.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
 "street": {
          "number": 8746,
          "name": "Cours Charlemagne"
        }
 */
@Parcelize
data class Street(
    val number: Int,
    val name: String,
) : Parcelable
