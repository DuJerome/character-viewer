package com.sample.thewire.network

import com.sample.simpsonsviewer.network.SimpsonsListServices
import com.sample.simpsonsviewer.repository.SimpsonsListRepository
import com.sample.simpsonsviewer.viewmodel.SimpsonsListViewModel
import com.sample.thewire.repository.TheWireListRepository
import com.sample.thewire.viewmodel.TheWireListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TheWireListViewModelModule {
    @Singleton
    @Provides
    fun provideTheWireListServices(retrofit: Retrofit): TheWireListServices =
        retrofit.create(TheWireListServices::class.java)

    @Singleton
    @Provides
    fun provideTheWireListRepository(
        theWireListServices: TheWireListServices
    ): TheWireListRepository {
        return TheWireListRepository(theWireListServices)
    }

    @Singleton
    @Provides
    fun provideTheWireListViewModel(theWireListRepository: TheWireListRepository): TheWireListViewModel {
        return TheWireListViewModel(theWireListRepository)
    }
}