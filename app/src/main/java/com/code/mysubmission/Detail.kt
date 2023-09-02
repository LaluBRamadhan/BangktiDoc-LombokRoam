package com.code.mysubmission

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Detail : AppCompatActivity() {




    companion object{
        const val EXTRA = "extra"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val judulDestinasi: TextView = findViewById(R.id.tv_juduldestinasi)
        val deskripsi: TextView = findViewById(R.id.tv_deskripsi)
        val lokasi:TextView = findViewById(R.id.tv_lokasi)
        val image: ImageView = findViewById(R.id.iv_gambar)

        val destinasi = if (Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Destinasi>(EXTRA, Destinasi::class.java)
        }else{
            @Suppress("DEPRICATION")
            intent.getParcelableExtra(EXTRA)
        }
        if(destinasi != null){
            judulDestinasi.text = destinasi.nama
            deskripsi.text = destinasi.deskripsi
            lokasi.text = destinasi.lokasi
            image.setImageResource(destinasi.photo)
        }
    }
}