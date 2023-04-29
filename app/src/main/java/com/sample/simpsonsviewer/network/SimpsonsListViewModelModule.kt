package com.sample.simpsonsviewer.network

import com.sample.simpsonsviewer.repository.SimpsonsListRepository
import com.sample.simpsonsviewer.viewmodel.SimpsonsListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SimpsonsListViewModelModule {

    @Singleton
    @Provides
    fun provideSimpsonsListServices(retrofit: Retrofit): SimpsonsListServices =
        retrofit.create(SimpsonsListServices::class.java)

    @Singleton
    @Provides
    fun provideSimpsonsListRepository(
        simpsonsListServices: SimpsonsListServices
    ): SimpsonsListRepository {
        return SimpsonsListRepository(simpsonsListServices)
    }

    @Singleton
    @Provides
    fun provideSimpsonsListViewModel(simpsonsListRepository: SimpsonsListRepository): SimpsonsListViewModel {
        return SimpsonsListViewModel(simpsonsListRepository)
    }
}