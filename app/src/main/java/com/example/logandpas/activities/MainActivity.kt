package com.example.logandpas.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bolts.Task
import com.example.logandpas.asynks.AsynkMethod
import com.example.logandpas.utils.setError
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var task: Task<String?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.logandpas.R.layout.activity_main)

        if (savedInstanceState != null) {
            login.setText(savedInstanceState.getString("LOGIN"))
            password.setText(savedInstanceState.getString("PASSWORD"))
        }

        btn_login.setOnClickListener {
            if (login.text.isEmpty() || password.text.isEmpty())
                setError("Заполните поля!", error)
            else if (!login.text.toString().contains(Regex(""".*@.*\..*""")))
                setError("Введите корректный e-mail!", error)
            else {
                task = AsynkMethod(login.text.toString(), password.text.toString(), error).fetchAsync()
                /*если прогонять через дебаг task вернет то, что нужно,
                если просто запустить приложение task вернет null
                 */
                if (task?.result != null) {
                    startActivity(
                        Intent(this, InfoActivity::class.java)
                            .putExtra("PERSON", task?.result)
                            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    )
                } else {
                    setError("Profile is empty", error)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putString("LOGIN", login.text.toString())
            putString("PASSWORD", password.text.toString())
        }
    }

}
