package fr.isen.tuveny.androidcontactds

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import fr.isen.tuveny.androidcontactds.databinding.ActivityMainBinding
import fr.isen.tuveny.androidcontactds.model.ExtraEnum
import fr.isen.tuveny.androidcontactds.model.api.APIResult
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    companion object {
        const val URL = "https://randomuser.me/api/?results=10&nat=fr"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HomeContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = HomeContactAdapter(mutableListOf()) {
            Log.i("MainActivity", "Contact clicked: ${it.fullName}")
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra(ExtraEnum.CONTACT.name, it)
            startActivity(intent)
        }
        binding.homeContactListRV.adapter = adapter
        binding.homeContactListRV.layoutManager = LinearLayoutManager(this)
        binding.homeContactListRV.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        requestContacts()
    }

    private fun requestContacts() {
        val queue = Volley.newRequestQueue(this)

        val request = JsonObjectRequest(
            Request.Method.GET,
            URL,
            null,
            { response ->
                onResponse(response)
            },
            { error ->
                onError(error)
            }
        )
        queue.add(request)
    }

    private fun onError(error: VolleyError) {
        Log.e("MainActivity", error.toString())
        Snackbar.make(binding.root, "Error loading Contacts", Snackbar.LENGTH_LONG).show()
    }

    private fun onResponse(response: JSONObject) {
        Log.i("MainActivity", response.toString())
        val apiResult = Gson().fromJson(response.toString(), APIResult::class.java)
        val contacts = apiResult.results
        adapter.updateList(contacts)
    }
}