package br.com.fiap.smartcontactsagenda.view.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.smartcontactsagenda.R
import br.com.fiap.smartcontactsagenda.view.about.AboutActivity
import br.com.fiap.smartcontactsagenda.view.contact.EditcContactActivity
import br.com.fiap.smartcontactsagenda.view.contact.ListContactActivity
import br.com.fiap.smartcontactsagenda.view.contact.SaveContactActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddContact.setOnClickListener {
            val nextScreen = Intent(this@MainActivity, SaveContactActivity::class.java)
            startActivity(nextScreen)
            finish()
        }

        btnEditContact.setOnClickListener {
            val nextScreen = Intent(this@MainActivity, EditcContactActivity::class.java)
            startActivity(nextScreen)
            finish()
        }

        btnRemoveContact.setOnClickListener {
            val nextScreen = Intent(this@MainActivity, EditcContactActivity::class.java)
            startActivity(nextScreen)
            finish()
        }

        btnAbout.setOnClickListener {
            val nextScreen = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(nextScreen)
            finish()
        }

        btnListContact.setOnClickListener {
            val nextScreen = Intent(this@MainActivity, ListContactActivity::class.java)
            startActivity(nextScreen)
            finish()
        }
    }

}
