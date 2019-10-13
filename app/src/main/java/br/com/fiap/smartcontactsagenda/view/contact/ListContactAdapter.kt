package br.com.fiap.smartcontactsagenda.view.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.smartcontactsagenda.R
import br.com.fiap.smartcontactsagenda.model.Contact
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.contact_list_item.view.*

class ListContactsAdapter(
    val Contacts: List<Contact>,
    val picasso: Picasso,
    val clickListener: (Contact) -> Unit
) : RecyclerView.Adapter<ListContactsAdapter.ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item, parent, false)
        return ContactViewHolder(view)
    }
    override fun getItemCount(): Int {
        return Contacts.size
    }
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val Contact = Contacts[position]
        holder.bindView(Contact, picasso, clickListener)
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(Contact: Contact,
                     picasso: Picasso,
                     clickListener: (Contact) -> Unit) = with(itemView) {
            tvName.text = Contact.name
            tvTelefone.text = Contact.phoneNumber
            tvEmail.text = Contact.email
            //picasso.load("https://pokedexdx.herokuapp.com${Contact.imageURL}").into(ivContact)

            setOnClickListener { clickListener(Contact) }
        }
    }
}
