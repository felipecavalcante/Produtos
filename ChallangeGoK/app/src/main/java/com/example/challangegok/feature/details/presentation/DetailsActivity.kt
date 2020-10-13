package com.example.challangegok.feature.details.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.challangegok.R
import com.example.challangegok.base.extensions.requireParcelable
import com.example.challangegok.databinding.ActivityDetailsBinding
import com.example.challangegok.feature.home.model.GenericModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class DetailsActivity : AppCompatActivity() {

    val bundle by lazy { requireParcelable<GenericModel>(DETAILS) }

    lateinit var binding: ActivityDetailsBinding
    lateinit var viewModel: DetailsActivityViewModel

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)
        viewModel =ViewModelProvider(this, factory).get(DetailsActivityViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    companion object {
        private const val DETAILS = "details"
        fun createIntent(context: Context, bundle: GenericModel): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtras(Bundle().apply {
                putParcelable(DETAILS, bundle)
            })
            return intent
        }
    }
}