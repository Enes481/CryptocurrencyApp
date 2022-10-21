package com.enestigli.cryptocurrencyapp.domain.repository

import com.enestigli.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import com.enestigli.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinById (coinId:String) : CoinDetailDto

}