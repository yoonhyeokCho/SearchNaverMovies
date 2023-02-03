package com.example.dbassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dbassignment.databinding.RowBinding
import com.example.dbassignment.databinding.SecondrowBinding

class SecondAdapter (val items:ArrayList<ActorForSecond>): RecyclerView.Adapter<SecondAdapter.ViewHolder>() {




    inner class ViewHolder(val binding: SecondrowBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondAdapter.ViewHolder {
        val binding = SecondrowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            actorName.text = items[position].actor_name
            actorRole.text = items[position].actor_role
            Glide.with(holder.itemView)
                .load(items[position].actor_image)
                .placeholder(R.drawable.ic_baseline_cloud_download_24)
                .into(actorImg)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}