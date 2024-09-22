package com.example.myapplaunchweather.di

import android.content.Context
import androidx.room.Room
import com.example.myapplaunchweather.BuildConfig
import com.example.myapplaunchweather.data.local.UserDao
import com.example.myapplaunchweather.data.local.UserDatabase
import com.example.myapplaunchweather.data.remote.network.WeatherApi
import com.example.myapplaunchweather.domain.repository.UserRepository
import com.example.myapplaunchweather.data.repository.WeatherRepositoryImpl
import com.example.myapplaunchweather.domain.repository.DataStoreRepository
import com.example.myapplaunchweather.domain.repository.WeatherRepository
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

    @Singleton
    @Provides
    fun getRepository(dao: UserDao): UserRepository {
        return UserRepository(dao)
    }

    @Singleton
    @Provides
    fun getDao(database: UserDatabase): UserDao {
        return database.dao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context.applicationContext, UserDatabase::class.java, "user_database"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideDataStoreRepository(
        @ApplicationContext context: Context
    ) = DataStoreRepository(context = context)
}
