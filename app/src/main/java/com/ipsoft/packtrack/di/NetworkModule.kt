package com.ipsoft.packtrack.di

import com.ipsoft.packtrack.BuildConfig
import com.ipsoft.packtrack.common.Constants
import com.ipsoft.packtrack.data.remote.TrackApi
import com.ipsoft.packtrack.data.remote.TrackService
import com.ipsoft.packtrack.data.repository.TrackRepositoryImpl
import com.ipsoft.packtrack.domain.repository.TrackRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideTrackRepository(service: TrackService): TrackRepository =
        TrackRepositoryImpl(service)

    @Provides
    @Singleton
    fun createTrackService(retrofit: Retrofit): TrackApi {
        return retrofit.create(TrackApi::class.java)
    }


    private fun createClient(): OkHttpClient {

        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor()


        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }

        okHttpClientBuilder.addInterceptor(loggingInterceptor)

        return okHttpClientBuilder.build()
    }

}