package br.com.fiap.smartcontactsagenda.view.contact

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.fiap.smartcontactsagenda.R
import br.com.fiap.smartcontactsagenda.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list_contact.*
import kotlinx.android.synthetic.main.include_loading.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListContactActivity : AppCompatActivity() {

    val listContactsViewModel: ListContactViewModel by viewModel()

    val picasso: Picasso by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_contact)


        //listContactsViewModel.getContacts(user = user)

        listContactsViewModel.isLoading.observe(this, Observer {
            if (it == true) {
                containerLoading.visibility = View.VISIBLE
            } else {
                containerLoading.visibility = View.GONE
            }

        })

        listContactsViewModel.messageError.observe(this, Observer {
            if (it != "") {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

        listContactsViewModel.contacts.observe(this, Observer {
            rvContacts.adapter = ListContactsAdapter(it, picasso) {
                val intent = Intent(this, EditcContactActivity::class.java)
                intent.putExtra("CONTACT", it)
                startActivity(intent)
                finish()
            }
            rvContacts.layoutManager = GridLayoutManager(this, 3)
        })

    }
}

