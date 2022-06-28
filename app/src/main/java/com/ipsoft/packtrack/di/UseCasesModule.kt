package com.ipsoft.packtrack.di

import com.ipsoft.packtrack.domain.usecases.GetTrackingInfoUseCase
import com.ipsoft.packtrack.domain.repository.TrackRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun provideGetTrackingInfoUseCase(repository: TrackRepository): GetTrackingInfoUseCase {
        return GetTrackingInfoUseCase(repository)
    }


}