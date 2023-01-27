package fr.isen.tuveny.androidcontactds.model.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.Locale

@Parcelize
data class Contact(
    val name: Name,
    val location: Location,
    val email: String,
    val cell: String,
    val picture: Picture,
    val dob: Dob,

    ) : Parcelable {
    val fullName: String
        get() = "${name.first} ${name.last}"
    val fullAddress: String
        get() = "${location.street.number} ${location.street.name}, ${location.city}"
    val largePicture: String?
        get() {
            // If the image is an empty string, the app crash with Picasso
            if (picture.large.startsWith("http")) {
                return picture.large
            }
            return null
        }
    val mediumPicture: String?
        get() {
            // If the image is an empty string, the app crash with Picasso
            if (picture.medium.startsWith("http")) {
                return picture.medium
            }
            return null
        }
    val birthday: String?
        get() {
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            try {
                val date = format.parse(dob.date) ?: return null
                return SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date)
            } catch (e: Exception) {
                return null
            }
        }
}
