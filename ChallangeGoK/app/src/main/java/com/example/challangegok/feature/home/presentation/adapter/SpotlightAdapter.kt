package com.example.challangegok.feature.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challangegok.databinding.CardSpotlightBinding
import com.example.challangegok.feature.home.model.GenericModel


class SpotlightAdapter(
    private val items: List<GenericModel>,
    val func: (GenericModel) -> Unit
) : RecyclerView.Adapter<SpotlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardSpotlightBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.card.setOnClickListener {
            func(items[position])
        }
    }

    inner class ViewHolder(private val binding: CardSpotlightBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val card = binding.cardSpotlight
        fun bind(item: GenericModel) {
            binding.spotlightModel = item
            binding.executePendingBindings()
        }
    }
}