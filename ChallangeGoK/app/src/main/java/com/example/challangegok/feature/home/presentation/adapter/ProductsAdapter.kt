package com.example.challangegok.feature.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challangegok.databinding.CardProductsBinding
import com.example.challangegok.feature.home.model.GenericModel

class ProductsAdapter(
    private val items: List<GenericModel>,
    val func: (item: GenericModel) -> Unit
) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardProductsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
        holder.card.setOnClickListener {
            func(items[position])
        }
    }

    inner class ViewHolder(private val binding: CardProductsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val card = binding.cardProduct
        fun bind(item: GenericModel) {
            binding.productsModel = item
            binding.executePendingBindings()
        }
    }
}