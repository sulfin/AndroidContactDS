package fr.isen.tuveny.androidcontactds.model.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class APIResult(
    val results: List<Contact>,
) : Parcelable
