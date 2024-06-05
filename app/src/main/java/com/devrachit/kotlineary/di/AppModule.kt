package com.devrachit.kotlineary.di

import com.devrachit.kotlineary.common.Constants
import com.devrachit.kotlineary.data.remote.spoonacularApi
import com.devrachit.kotlineary.data.repository.SpoonacularRepositoryImpl
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesSpoonacularApi(): spoonacularApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(spoonacularApi::class.java)
    }

    @Provides
    @Singleton
    fun providesSpoontacularRepository(api: spoonacularApi): SpoonacularRepository {
        return SpoonacularRepositoryImpl(api)
    }
}