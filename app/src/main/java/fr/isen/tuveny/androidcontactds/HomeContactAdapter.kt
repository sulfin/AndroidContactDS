package fr.isen.tuveny.androidcontactds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.isen.tuveny.androidcontactds.databinding.CellHomeContactBinding
import fr.isen.tuveny.androidcontactds.model.Contact

class HomeContactAdapter(private val contactList: MutableList<Contact>) : RecyclerView.Adapter<HomeContactAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CellHomeContactBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout = inflater.inflate(R.layout.cell_home_contact, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactList[position]
        holder.binding.cellContactName.text = contact.name
        holder.binding.cellContactAddress.text = contact.address
        holder.binding.cellContactEmail.text = contact.email
    }

    override fun getItemCount() = contactList.size
}