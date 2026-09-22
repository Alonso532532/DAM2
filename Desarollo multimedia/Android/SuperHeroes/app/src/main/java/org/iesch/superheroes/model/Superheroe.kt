package org.iesch.superheroes.model

import android.os.Parcelable

@Parcelable
data class Superheroe (
    val nombre: String,
    val alterEgo: String,
    val bio: String,
    val poder: Float
) : Parcelable
