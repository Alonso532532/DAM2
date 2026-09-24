package org.iesch.superheroes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Creo un objeto parcelizable para podr pasar los objetos de forma más sencilla
@Parcelize
data class Superheroe (
    val nombre: String,
    val alterEgo: String,
    val bio: String,
    val poder: Float
) : Parcelable