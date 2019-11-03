package org.wit.ringfort.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_ringfort.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.ringfort.R
import org.wit.ringfort.helpers.readImage
import org.wit.ringfort.helpers.readImageFromPath
import org.wit.ringfort.helpers.showImagePicker
import org.wit.ringfort.main.MainApp
import org.wit.ringfort.models.RingfortModel
import java.util.ArrayList
import java.nio.file.Files.size
//import android.R



class RingfortActivity : AppCompatActivity(), AnkoLogger {


    var ringfort = RingfortModel()
    val IMAGE_REQUEST = 1
    lateinit var app: MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(org.wit.ringfort.R.layout.activity_ringfort)
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
            btnAdd.setText(org.wit.ringfort.R.string.save_ringfort)
            ringfortImage.setImageBitmap(readImageFromPath(this, ringfort.image))
            if (ringfort.image != null) {
                chooseImage.setText(org.wit.ringfort.R.string.change_ringfort_image)
            }

        }

        btnAdd.setOnClickListener() {
            ringfort.title = ringfortTitle.text.toString()
            ringfort.description = description.text.toString()
            if (ringfort.title.isEmpty()) {
                toast(org.wit.ringfort.R.string.enter_ringfort_title)
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

        chooseImage.setOnClickListener {
            showImagePicker(this, IMAGE_REQUEST)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(org.wit.ringfort.R.menu.menu_ringfort, menu)
        return super.onCreateOptionsMenu(menu)

//        if (mState === HIDE_MENU) {
//            for (i in 0 until menu.size())
//                menu.getItem(i).isVisible = false
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            org.wit.ringfort.R.id.item_delete -> {
                app.ringforts.delete(ringfort)
                setResult(AppCompatActivity.RESULT_OK)
                finish()
            }
            org.wit.ringfort.R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    //used for dispalying image after picker activity ends
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            IMAGE_REQUEST -> {
                if (data != null) {
                    ringfort.image = data.getData().toString()
                    ringfortImage.setImageBitmap(readImage(this, resultCode, data))
                    chooseImage.setText(org.wit.ringfort.R.string.change_ringfort_image)
                }
            }
        }
    }

}
