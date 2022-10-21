package com.enestigli.cryptocurrencyapp.presentation.coin_list

import com.enestigli.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins:List<Coin> = emptyList(),
    val error:String = ""
)
