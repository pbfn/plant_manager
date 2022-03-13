package com.pedrobruno.plant_manager.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pedrobruno.plant_manager.databinding.EnvironmentItemAdapterBinding
import com.pedrobruno.plant_manager.domain.model.Environment

class AdapterEnvironment() :
    RecyclerView.Adapter<AdapterEnvironment.AdapterEnvironmentViewHolder>() {

    class AdapterEnvironmentViewHolder(itemView: EnvironmentItemAdapterBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val environmentName = itemView.textViewName
    }

    private val differCallback = object : DiffUtil.ItemCallback<Environment>() {
        override fun areItemsTheSame(oldItem: Environment, newItem: Environment): Boolean {
            return oldItem.key == newItem.key
        }

        override fun areContentsTheSame(oldItem: Environment, newItem: Environment): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterEnvironmentViewHolder {
        val binding = EnvironmentItemAdapterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AdapterEnvironmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterEnvironmentViewHolder, position: Int) {
        val environment = differ.currentList[position]
        holder.apply {
            environmentName.text = environment.name
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}