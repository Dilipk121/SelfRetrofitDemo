package com.example.selfretrofitdemo.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.selfretrofitdemo.R
import com.example.selfretrofitdemo.UserSecondActivity
import com.example.selfretrofitdemo.data.User
import com.mikhaellopez.circularimageview.CircularImageView
import com.squareup.picasso.Picasso

class MyCompanyAdapter(val context: Activity, val companyUserList: List<User>) :
    RecyclerView.Adapter<MyCompanyAdapter.AwsomeViewHolder>() {

    inner class AwsomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var u_iamge: CircularImageView
        var u_names: TextView
        var u_email: TextView
        var u_mobile: TextView
        var cont_row: ConstraintLayout
        var cardView: CardView

        init {
            u_iamge = itemView.findViewById(R.id.circularImageView)
            u_names = itemView.findViewById(R.id.tv_names)
            u_email = itemView.findViewById(R.id.tv_email)
            u_mobile = itemView.findViewById(R.id.tv_mobile)
            cont_row = itemView.findViewById(R.id.constraint_row)
            cardView = itemView.findViewById(R.id.cardView)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AwsomeViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item_list, parent, false)
        return AwsomeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return companyUserList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AwsomeViewHolder, position: Int) {
        val currentItems = companyUserList[position]

        holder.u_names.text =
            currentItems.firstName + " " + currentItems.maidenName + " " + currentItems.lastName
        holder.u_email.text = currentItems.email
        holder.u_mobile.text = currentItems.phone

        //here we are use picasso library to display string url image into image view
        Picasso.get().load(currentItems.image).into(holder.u_iamge)

        val context_holder = holder.cont_row.context

        holder.cont_row.setOnClickListener() {

            val intent = Intent(it.context, UserSecondActivity::class.java)

            val nameStr = currentItems.firstName + " " + currentItems.maidenName + " " + currentItems.lastName

            intent.putExtra("UserName",nameStr)
            intent.putExtra("UserEmail",currentItems.email)
            intent.putExtra("UserMobile",currentItems.phone)
            intent.putExtra("UserImage",currentItems.image)

            it.context.startActivity(intent)


            Toast.makeText(
                context_holder,
                "on Clicked ${currentItems.firstName}",
                Toast.LENGTH_SHORT
            ).show()
        }

        //animation, just change xml anim file to see more animation
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.cardView.context,R.anim.scale_up))


    }

}