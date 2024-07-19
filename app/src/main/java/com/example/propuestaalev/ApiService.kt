package com.example.propuestaalev

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val loginUsuario: String, val loginContrasena: String)

interface ApiService {
    @GET("pedidoEstado")
    fun getStatuses(): Call<List<StatusResponse>>
    @POST("login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

}