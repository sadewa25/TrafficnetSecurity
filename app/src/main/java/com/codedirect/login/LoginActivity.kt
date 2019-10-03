package com.codedirect.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.codedirect.trafficnetsecurity.MainActivity
import com.codedirect.trafficnetsecurity.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.login_btn -> {startActivity<MainActivity>()}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener(this)
    }
}
