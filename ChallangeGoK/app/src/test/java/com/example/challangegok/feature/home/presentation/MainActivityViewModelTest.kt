package com.example.challangegok.feature.home.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.challangegok.Seeds
import com.example.challangegok.Seeds.genericModel
import com.example.challangegok.feature.home.data.repository.ApiRepository
import com.example.challangegok.feature.home.model.GenericModel
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Rule
import org.junit.Test

class MainActivityViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val schedulers = Schedulers.trampoline()
    private val repository = mock<ApiRepository>()
    private val observableShowLoading = mock<Observer<Boolean>>()
    private val observerError = mock<Observer<Unit>>()
    private val observerProductsTitle = mock<Observer<Boolean>>()
    private val observerGenericModel = mock<Observer<GenericModel>>()
    private val observerListGenericModel = mock<Observer<List<GenericModel>>>()


    private fun initializeViewModel(): MainActivityViewModel {
        val viewModel = MainActivityViewModel(
            mainScheduler = schedulers,
            ioScheduler = schedulers,
            repository = repository
        )

        viewModel.cash.observeForever(observerGenericModel)
        viewModel.spotlight.observeForever(observerListGenericModel)
        viewModel.productsTitleVisibility.observeForever(observerProductsTitle)
        viewModel.error.observeForever(observerError)
        viewModel.showLoading.observeForever(observableShowLoading)
        return viewModel
    }


    @Test
    fun `should return a generic model when call fetch cards`() {
        given(repository.requestInfo()).willReturn(Single.just(Seeds.repositoryMockResponse))

        initializeViewModel().fetchCards()

        verify(observableShowLoading).onChanged(true)
        verify(observableShowLoading).onChanged(false)
        verify(observerListGenericModel).onChanged(listOf(genericModel))
        verify(observerProductsTitle).onChanged(true)
        verify(observerGenericModel).onChanged(genericModel)
    }

    @Test
    fun `should return an error when call fetch cards in case `() {
        val error = Throwable()
        given(repository.requestInfo()).willReturn(Single.error(error))

        initializeViewModel().fetchCards()

        verify(observableShowLoading).onChanged(true)
        verify(observableShowLoading).onChanged(false)
        verify(observerProductsTitle).onChanged(false)
        verify(observerError).onChanged(null)
    }
}