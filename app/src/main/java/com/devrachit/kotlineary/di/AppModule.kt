package com.devrachit.kotlineary.di

import android.content.Context
import androidx.room.Room
import com.devrachit.kotlineary.common.Constants
import com.devrachit.kotlineary.data.remote.spoonacularApi
import com.devrachit.kotlineary.data.repository.SpoonacularRepositoryImpl
import com.devrachit.kotlineary.domain.repository.SpoonacularRepository
import com.devrachit.kotlineary.room.AppDatabase
import com.devrachit.kotlineary.room.FavoriteRecipeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFavoriteRecipeDao(database: AppDatabase): FavoriteRecipeDao {
        return database.favoriteRecipeDao()
    }
}