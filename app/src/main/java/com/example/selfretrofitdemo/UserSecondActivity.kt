package com.example.selfretrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso

class UserSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_second)

        val tv_usr_name = findViewById<TextView>(R.id.tv_usrName)
        val tv_usr_email = findViewById<TextView>(R.id.tv_email)
        val tv_usr_mobile = findViewById<TextView>(R.id.tv_phone)
        val tv_usr_image = findViewById<CircularImageView>(R.id.usr_circularImageView)


        val u_name = intent.getStringExtra("UserName")
        val u_email = intent.getStringExtra("UserEmail")
        val u_mobile = intent.getStringExtra("UserMobile")
        val u_image = intent.getStringExtra("UserImage")



        //here we are use picasso library to display string url image into image view
        Picasso.get().load(u_image).into(tv_usr_image)

        tv_usr_mobile.text = u_mobile
        tv_usr_email.text = u_email
        tv_usr_name.text = u_name



    }
}