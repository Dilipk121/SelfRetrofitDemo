package com.example.selfretrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.selfretrofitdemo.adapter.MyCompanyAdapter
import com.example.selfretrofitdemo.apiinterface.CompanyUserData
import com.example.selfretrofitdemo.data.User
import com.example.selfretrofitdemo.data.mUserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var myCompanyAdapter: MyCompanyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)
        myRecyclerView.layoutManager = LinearLayoutManager(this)



        //call the retrofit
        val retroFitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CompanyUserData::class.java) //call that Interface

        val retrofitData = retroFitBuilder.getAllUserData() // call here Interface Function

        retrofitData.enqueue(object : Callback<mUserData?> {
            override fun onResponse(call: Call<mUserData?>, response: Response<mUserData?>) {
               val responseBody = response.body() // call all body of API data
                val responseDataList: List<User> = responseBody?.users !! //
                //this is the final data list ,use this data and populate into recycler view


                //call to my adapter
                myCompanyAdapter = MyCompanyAdapter(this@MainActivity,responseDataList)

                //pass all data to recycler view
                myRecyclerView.adapter = myCompanyAdapter


                //its just checking API is working or not
/*                val test = StringBuilder()
                for (i in responseDataList) {

                    test.append(i.firstName + " ")
                }
                val tv = findViewById<TextView>(R.id.textView)
                tv.text = test // set the API data into TextView*/

            }

            override fun onFailure(call: Call<mUserData?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "OnFailure ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })





    }
}