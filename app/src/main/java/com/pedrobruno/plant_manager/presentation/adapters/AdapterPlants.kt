package com.pedrobruno.plant_manager.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedrobruno.plant_manager.databinding.PlantsItemAdapterBinding
import com.pedrobruno.plant_manager.domain.model.Plant

class AdapterPlants() : RecyclerView.Adapter<AdapterPlants.AdapterPlantsViewHolder>() {

    class AdapterPlantsViewHolder(itemView: PlantsItemAdapterBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val plantName = itemView.textViewNamePlant
        val imagePlant = itemView.imageViewPlant
    }

    private val differCallback = object : DiffUtil.ItemCallback<Plant>() {
        override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPlantsViewHolder {
        val binding = PlantsItemAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return AdapterPlantsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterPlantsViewHolder, position: Int) {
        val plant = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(plant.link_photo).into(holder.imagePlant)
        }
        holder.apply {
            plantName.text = plant.name
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}