package com.example.selfretrofitdemo.data

data class mUserData(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<User>
)