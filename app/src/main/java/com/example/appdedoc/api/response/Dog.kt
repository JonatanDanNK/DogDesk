package com.example.appdedoc.api.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dog(
    val created_at: String,
    val type: String,
    val heightFemale: String,
    val heightMale: String,
    val id: Int,
    val imageUrl: String,
    val index: Int,
    val life_expectancy: String,
    val ml_id: String,
    val name_en: String,
    val name_es: String,
    val temperament: String,
    val temperament_en: String,
    val updated_at: String,
    val weight_female: String,
    val weight_male: String
) : Parcelable