package com.example.day26

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter (val context : Activity, val productArrayList : List<Product>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
                //image view , how to show image in image view if the image is in form of url, 3rd party library
                //use 3rd party library picasso


        holder.ratingBar.numStars = currentItem.rating.toInt()
        Picasso.get().load(currentItem.thumbnail).into(holder.image)

    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title : TextView
        var ratingBar : RatingBar
        var image : ShapeableImageView
        init{
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.productImage)
            ratingBar = itemView.findViewById(R.id.ratingBar)
        }

    }

}