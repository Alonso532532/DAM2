package com.example.practica.model;

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Datos(
        val resultado: String,
        val imagen1: Bitmap?,
        val imagen2: String,
) : Parcelable {
}

