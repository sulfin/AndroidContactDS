package fr.isen.tuveny.androidcontactds.model.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dob(
    val age: Int,
    val date: String
) : Parcelable
