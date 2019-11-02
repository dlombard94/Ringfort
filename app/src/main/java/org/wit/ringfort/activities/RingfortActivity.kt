package org.wit.ringfort.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_ringfort.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.ringfort.R
import org.wit.ringfort.main.MainApp
import org.wit.ringfort.models.RingfortModel
import java.util.ArrayList

class RingfortActivity : AppCompatActivity(), AnkoLogger {


    var ringfort = RingfortModel()
    lateinit var app: MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ringfort)
        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)
        info("Ringfort Activity started..")

        app = application as MainApp
        var edit = false

        //this retrieves clciked on ringfort via .hasExtra
        //gotten from onRingfortClick
        //if created through add toolbar this will be skipped
        if (intent.hasExtra("ringfort_edit")) {
            edit = true
            ringfort = intent.extras?.getParcelable<RingfortModel>("ringfort_edit")!!
            ringfortTitle.setText(ringfort.title)
            description.setText(ringfort.description)
            btnAdd.setText(R.string.save_ringfort)

        }

        btnAdd.setOnClickListener() {
            ringfort.title = ringfortTitle.text.toString()
            ringfort.description = description.text.toString()
            if (ringfort.title.isEmpty()) {
                toast(R.string.enter_ringfort_title)
            } else {
                if (edit) {
                    app.ringforts.update(ringfort.copy())
                } else {
                    app.ringforts.create(ringfort.copy())
                }
            }
            info("add Button Pressed: $ringfortTitle")
            setResult(AppCompatActivity.RESULT_OK)
            finish()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ringfort, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
