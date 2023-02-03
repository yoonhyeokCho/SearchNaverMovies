package com.example.dbassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dbassignment.databinding.RowBinding

class DirectorAdapter(val items:ArrayList<DirectorResponseItem>): RecyclerView.Adapter<DirectorAdapter.ViewHolder>() {
    interface OnItemClickListener{
        fun OnItemClick(data:DirectorResponseItem)
    }

    var itemClickListener:OnItemClickListener?=null

    inner class ViewHolder(val binding: RowBinding): RecyclerView.ViewHolder(binding.root){
        init{
            binding.rowtitleText.setOnClickListener {
                itemClickListener?.OnItemClick(items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DirectorAdapter.ViewHolder {
        val binding = RowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val movieTitle = items[position].movie_title
            if (movieTitle.length>=10){
                rowtitleText.text = "${movieTitle.substring(0, 10)}..."
            }else{
                rowtitleText.text = movieTitle
            }
            runningTime.text = "상영시간 : ${items[position].playing_time} 분"
            openingDateText.text = "개봉일 : ${items[position].opening_date} 년"
            movieRate.text = items[position].movie_rate
            Glide.with(holder.itemView)
                .load(items[position].image)
                .placeholder(R.drawable.ic_baseline_cloud_download_24)
                .into(movieImg)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}