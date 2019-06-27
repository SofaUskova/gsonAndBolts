package com.example.logandpas.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.logandpas.R
import com.example.logandpas.server.Profil
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val person = Gson().fromJson(intent.getStringExtra("PERSON"), Profil::class.java)

        if (savedInstanceState != null) {
            mail.text = savedInstanceState.getString("MAIL")
            first_name.text = savedInstanceState.getString("FIRST_NAME")
            last_name.text = savedInstanceState.getString("LAST_NAME")
            birth.text = savedInstanceState.getString("BIRTH_DATE")
            notes.text = savedInstanceState.getString("NOTES")
        } else {
            mail.text = getString(R.string.mail, person.mail)
            first_name.text = getString(R.string.first_name, person.firstName)
            last_name.text = getString(R.string.last_name, person.lastName)
            birth.text = getString(R.string.birth_date, person.birthDate)
            notes.text = getString(R.string.note, person.notes)
        }

        btn_logout.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putString("MAIL", mail.text.toString())
            putString("FIRST_NAME", first_name.text.toString())
            putString("LAST_NAME", last_name.text.toString())
            putString("BIRTH_DATE", birth.text.toString())
            putString("NOTES", notes.text.toString())
        }
    }
}