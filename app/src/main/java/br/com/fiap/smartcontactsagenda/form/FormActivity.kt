package br.com.fiap.smartcontactsagenda.form

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.smartcontactsagenda.R
import br.com.fiap.smartcontactsagenda.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        btLogin.setOnClickListener{
            loadSignUp()
        }
    }


    private fun loadSignUp(){
        val nextScreen = Intent(this@FormActivity,SignUpActivity::class.java)
        startActivity(nextScreen)
        finish()
    }
}
