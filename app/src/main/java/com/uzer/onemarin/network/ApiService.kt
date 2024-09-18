package com.uzer.onemarin.network

import com.uzer.onemarin.data.model.ChainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("health")
    fun checkHealth(): Call<Void>

    @GET("/on/5")
    fun putoverAnchor(): Call<Void>

    @GET("/off/5")
    fun pickupAnchor(): Call<Void>

    @GET("/chain")
    fun getChainCounter(): Call<ChainModel>
}