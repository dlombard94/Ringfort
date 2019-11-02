package org.wit.ringfort.activities

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ringfort_list.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult
import org.wit.ringfort.R
import org.wit.ringfort.main.MainApp
import org.wit.ringfort.models.RingfortModel


class RingfortListActivity : AppCompatActivity(), RingfortListener {

    lateinit var app: MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ringfort_list)
        app = application as MainApp

        toolbar.title = title
        setSupportActionBar(toolbar)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = RingfortAdapter(app.ringforts.findAll(), this)
    }

    //crerates toolbar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //implements tolbar actions when icons pressed
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_add -> startActivityForResult<RingfortActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }

    //.putExra is passing the pressed ringfort to the ringfort activity
    //this is then retrieved in the onCreate()
    override fun onRingfortClick(ringfort: RingfortModel) {
        startActivityForResult(intentFor<RingfortActivity>().putExtra("ringfort_edit",ringfort), 0)
    }

    //updated list with correct values from model once and activity ends
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        recyclerView.adapter?.notifyDataSetChanged()
        super.onActivityResult(requestCode, resultCode, data)
    }
}

