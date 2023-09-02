package com.code.mysubmission

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.code.mysubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvDestinasi: RecyclerView
    private val list = ArrayList<Destinasi>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("LombokRoam")

        rvDestinasi = findViewById(R.id.rv_trip)
        rvDestinasi.setHasFixedSize(true)

        list.addAll(getDestinasi())
        show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("Recycle")
    private fun getDestinasi() : ArrayList<Destinasi>{
        val dataNama = resources.getStringArray(R.array.data_name)
        val dataDeskripsi = resources.getStringArray(R.array.data_description)
        val dataLokasi = resources.getStringArray(R.array.data_location)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listDestinasi = ArrayList<Destinasi>()
            for (i in dataNama.indices) {
                val destinasi = Destinasi(dataNama[i], dataDeskripsi[i], dataLokasi[i] ,dataPhoto.getResourceId(i, -1))
                listDestinasi.add(destinasi)
            }
        return listDestinasi
    }

    private fun show(){
        rvDestinasi.layoutManager = LinearLayoutManager(this)
        val listDestinasiAdapter = ListDestinationAdapter(list)
        rvDestinasi.adapter = listDestinasiAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_profile -> {
                val intent = Intent(this, profile::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}