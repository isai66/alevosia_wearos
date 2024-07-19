package com.example.propuestaalev

import java.io.Serializable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id_usuario: Int,
    val username: String,
    val nombre: String,
    val apellido: String,
    val codigopostal: String,
    val estado: String,
    val municipio: String,
    val colonia: String?,
    val calle: String,
    val telefono: Long,
    val numinterior: Int,
    val numexterior: Int,
    val passwords: String,
    val email: String,
    val rol: String?
) : Parcelable
