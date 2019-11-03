package org.wit.ringfort.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_ringfort.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.ringfort.R
import org.wit.ringfort.main.MainApp
import org.wit.ringfort.models.RingfortModel
import org.wit.ringfort.models.UserModel

class LoginActivity : AppCompatActivity(), AnkoLogger {
    var user = UserModel()

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        app = application as MainApp


        btnLogin.setOnClickListener() {
            user.username = appUsername.text.toString()
            user.password = appPassword.text.toString()
            var count = 0
            if (user.username.isEmpty() or user.password.isEmpty()) {
                toast(org.wit.ringfort.R.string.enter_missing_info)
            }else{
                for (i in app.users.findAll().indices){
                    if(app.users.findAll()[i].username.equals(user.username) && app.users.findAll()[i].password.equals(user.password)){
                        count++
                    }

                }
                if (count >= 1){
                    startActivity(Intent(this,RingfortListActivity::class.java))
                }else{
                    toast("Username or password invalid - renter or try registering")
                }

            }
        }

        btnRegister.setOnClickListener() {
            user.username = appUsername.text.toString()
            user.password = appPassword.text.toString()
            var count = 0;
            if (user.username.isEmpty() or user.password.isEmpty()) {
                toast(org.wit.ringfort.R.string.enter_missing_info)
            } else{
                for (i in app.users.findAll().indices){
                    if(app.users.findAll()[i].username.equals(user.username)){
                        count++
                    }

            }
                if (count >= 1){
                    toast("Username already in use - try another")
                }else{
                    app.users.register(user.copy())
                    startActivity(Intent(this,RingfortListActivity::class.java))
                }
            }
        }
    }
}
