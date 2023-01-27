package fr.isen.tuveny.androidcontactds

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.tuveny.androidcontactds.databinding.CellHomeContactBinding
import fr.isen.tuveny.androidcontactds.model.api.Contact

class HomeContactAdapter(private val contacts: MutableList<Contact>, val onViewClick: (Contact) -> Unit) :
    RecyclerView.Adapter<HomeContactAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = CellHomeContactBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val layout = inflater.inflate(R.layout.cell_home_contact, parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.binding.cellContactName.text = contact.fullName
        holder.binding.cellContactAddress.text = contact.fullAddress
        holder.binding.cellContactEmail.text = contact.email

        if (contact.mediumPicture != null) {
            Picasso.get().load(contact.mediumPicture)
                .placeholder(R.drawable.ic_person)
                .error(R.drawable.ic_person)
                .into(holder.binding.cellContactImage)
        }

        holder.itemView.setOnClickListener {
            onViewClick(contact)
        }
    }

    override fun getItemCount() = contacts.size
    fun updateList(contactsNew: List<Contact>) {
        contacts.clear()
        contacts.addAll(contactsNew)
        notifyDataSetChanged()
    }
}