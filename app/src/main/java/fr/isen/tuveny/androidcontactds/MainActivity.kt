package fr.isen.tuveny.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fr.isen.tuveny.androidcontactds.databinding.ActivityMainBinding
import fr.isen.tuveny.androidcontactds.model.Contact

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contacts = listOf(
            Contact("name 1", "address 1", "email 1", "image 1"),
            Contact("name 2", "address 2", "email 2", "image 2"),
            Contact("name 3", "address 3", "email 3", "image 3"),
            Contact("name 4", "address 4", "email 4", "image 4"),
        )

        val adapter = HomeContactAdapter(contacts.toMutableList())
        binding.homeContactListRV.adapter = adapter
        binding.homeContactListRV.layoutManager = LinearLayoutManager(this)


    }
}