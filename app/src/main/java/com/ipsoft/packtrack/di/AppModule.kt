package com.ipsoft.packtrack.di

import com.ipsoft.packtrack.BuildConfig
import com.ipsoft.packtrack.common.Constants
import com.ipsoft.packtrack.data.remote.CorreiosApi
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
object AppModule {

    @Provides
    @Singleton
    fun provideCorreiosApi(): CorreiosApi {


        val loggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            loggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()





        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(CorreiosApi::class.java)

    }


    @Provides
    @Singleton
    fun provideTrackRepository(api: CorreiosApi): TrackRepository = TrackRepositoryImpl(api)

}