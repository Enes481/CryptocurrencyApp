package com.enestigli.cryptocurrencyapp.presentation.coin_detail

import com.enestigli.cryptocurrencyapp.domain.model.Coin
import com.enestigli.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean = false,
    val coin:CoinDetail? =null,
    val error:String = ""
)
