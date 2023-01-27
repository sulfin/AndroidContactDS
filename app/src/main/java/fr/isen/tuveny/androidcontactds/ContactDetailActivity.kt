package fr.isen.tuveny.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import fr.isen.tuveny.androidcontactds.databinding.ActivityContactDetailBinding
import fr.isen.tuveny.androidcontactds.model.ExtraEnum
import fr.isen.tuveny.androidcontactds.model.api.Contact

class ContactDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contact: Contact? = intent.getParcelableExtra(ExtraEnum.CONTACT.name)

        if (contact != null) {
            binding.contactDetailName.text = contact.fullName
            binding.contactDetailCity.text = contact.fullAddress
            binding.contactDetailEmail.text = contact.email
            binding.contactDetailPhone.text = contact.cell
            if (contact.mediumPicture != null) {
                Picasso.get().load(contact.mediumPicture)
                    .placeholder(R.drawable.ic_person)
                    .error(R.drawable.ic_person)
                    .into(binding.contactDetailImage)
            }
            if(contact.birthday != null) {
                binding.contactDetailBirthday.text = contact.birthday
            }else {
                binding.contactDetailBirthday.text = "N/A"
            }
        }
    }
}