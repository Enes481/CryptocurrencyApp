package com.enestigli.cryptocurrencyapp.domain.model



//data -> remote -> dto -> CoinDto da açıklandığı gibi bu kullanıcıya ya da ui da göstermek istediğimiz veriler,CoinDto da api dan
//gelen verileri içeriyor

data class Coin(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,

)
