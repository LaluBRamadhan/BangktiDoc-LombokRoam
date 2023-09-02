package com.code.mysubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListDestinationAdapter(val listDestination: ArrayList<Destinasi>): RecyclerView.Adapter<ListDestinationAdapter.ListViewHolder>(){

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName:TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvLocation:TextView = itemView.findViewById(R.id.tv_item_location)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_destination,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama,deskripsi,lokasi,photo) = listDestination[position]
        holder.tvName.text = nama
        holder.tvDescription.text = deskripsi
        holder.tvLocation.text = lokasi
        holder.imgPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, Detail::class.java)
            intentDetail.putExtra(Detail.EXTRA,listDestination[position])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listDestination.size

}