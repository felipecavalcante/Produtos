package com.example.challangegok.feature.home.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challangegok.feature.home.data.repository.ApiRepository
import com.example.challangegok.feature.home.model.GenericModel
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class MainActivityViewModel @Inject   constructor(
    @Named("IO")
    private val ioScheduler: Scheduler,
    @Named("Main")
    private val mainScheduler: Scheduler,
    private val repository: ApiRepository

) : ViewModel() {
    private val disposable = CompositeDisposable()
    val showLoading = MutableLiveData<Boolean>()
    val productsTitleVisibility = MutableLiveData<Boolean>()
    val spotlight = MutableLiveData<List<GenericModel>>()
    val products = MutableLiveData<List<GenericModel>>()
    val error = MutableLiveData<Unit>()
    val click = MutableLiveData<Unit>()
    val cash = MutableLiveData<GenericModel>()

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    fun fetchCards() {
        disposable.add(repository.requestInfo()
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .doOnSubscribe {showLoading.value = true }
            .doFinally { showLoading.value = false}
            .subscribe({
                it?.let { response ->
                    spotlight.value = response.spotlight.map { map -> map!!.toGeneticModel() }
                    products.value = response.products.map { map -> map!!.toGenericModel() }
                    cash.value = response.cash!!.toGenericModel()
                    productsTitleVisibility.value = hasProducts()
                }
            }, {
                productsTitleVisibility.value = hasProducts()
                error.value = null
            })
        )
    }

    fun onCashCardClicked(){
        click.value = null
    }

    private fun hasProducts(): Boolean = !products.value.isNullOrEmpty()
}
