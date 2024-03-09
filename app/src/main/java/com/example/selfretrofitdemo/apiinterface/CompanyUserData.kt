package com.example.selfretrofitdemo.apiinterface

import com.example.selfretrofitdemo.data.mUserData
import retrofit2.Call
import retrofit2.http.GET

interface CompanyUserData {

    @GET("users") //use here last link from API
    fun getAllUserData() : Call<mUserData>

}