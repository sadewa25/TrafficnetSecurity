package com.codedirect.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codedirect.register.registerActivity
import com.codedirect.trafficnetsecurity.MainActivity
import com.codedirect.trafficnetsecurity.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        textRegister.setOnClickListener{
            val intent = Intent(this, registerActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
