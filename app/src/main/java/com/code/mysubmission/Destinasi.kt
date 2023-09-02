package com.code.mysubmission

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Destinasi(
    val nama:String,
    val deskripsi:String,
    val lokasi:String,
    val photo:Int,
):Parcelable
