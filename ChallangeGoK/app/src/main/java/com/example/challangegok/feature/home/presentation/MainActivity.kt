package com.example.challangegok.feature.home.presentation

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challangegok.R
import com.example.challangegok.databinding.ActivityMainBinding
import com.example.challangegok.feature.details.presentation.DetailsActivity
import com.example.challangegok.feature.home.model.GenericModel
import com.example.challangegok.feature.home.presentation.adapter.ProductsAdapter
import com.example.challangegok.feature.home.presentation.adapter.SpotlightAdapter
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setViewModel()
        setObservables()
        fetchCards()
    }

    private fun setViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, factory).get(MainActivityViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun setObservables() {
        viewModel.products.observe(this, {
            configureProducts(it)
        })
        viewModel.spotlight.observe(this, {
            configureSpotlight(it)
        })
        viewModel.error.observe(this, {
            showGenericError()
        })
        viewModel.click.observe(this, {
            openDetails(viewModel.cash.value!!)
        })
    }

    private fun configureProducts(products: List<GenericModel>) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerProducts.apply {
            adapter = ProductsAdapter(products) {
                openDetails(it)
            }
            layoutManager = linearLayoutManager
        }
    }

    private fun configureSpotlight(spotlight: List<GenericModel>) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerSpotlight.apply {
            adapter = SpotlightAdapter(spotlight) {
                openDetails(it)
            }
            layoutManager = linearLayoutManager
        }
    }

    private fun showGenericError() {
        AlertDialog.Builder(this)
            .setMessage("Parece que estámos com um problema")
            .setNegativeButton("Sair") { _, _ -> finishAffinity() }
            .setPositiveButton("Tentar novamente") { _, _ -> fetchCards() }.show()
    }

    private fun openDetails(genericModel: GenericModel){
        startActivity(DetailsActivity.createIntent(this, genericModel))
    }

    private fun fetchCards() {
        viewModel.fetchCards()
    }
}