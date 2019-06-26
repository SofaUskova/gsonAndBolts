package com.example.logandpas.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.logandpas.R
import com.example.logandpas.asynks.AsynkMethod
import com.example.logandpas.utils.setError
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (login.text.isEmpty() || password.text.isEmpty())
//            setError("Заполните поля!")
//        if (!password.text.matches(Regex("""/.+@.+\..+/i""")))
//            setError("Введите корректный e-mail!")

        btn_login.setOnClickListener {
                try{
                    val profil = AsynkMethod("john@domain.tld", "123123", error).fetchAsync()
                } catch(e: Exception){
                    setError(e.toString(), error)
                }
        }

    }

}
