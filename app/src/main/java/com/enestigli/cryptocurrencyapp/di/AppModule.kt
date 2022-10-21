package com.enestigli.cryptocurrencyapp.di

import androidx.compose.ui.unit.Constraints
import com.enestigli.cryptocurrencyapp.common.Constants
import com.enestigli.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.enestigli.cryptocurrencyapp.data.repository.CoinRepositoryImpl
import com.enestigli.cryptocurrencyapp.domain.repository.CoinRepository
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
    fun proivdePaprikaApi() : CoinPaprikaApi{

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)

    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaApi) : CoinRepository{

        return CoinRepositoryImpl(api)
    }


}