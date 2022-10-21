package com.enestigli.cryptocurrencyapp.data.remote.dto

import com.enestigli.cryptocurrencyapp.domain.model.Coin


//CoinDto api' dan gelen verilerden oluşuyor ancak biz her zaman kullanıcıya api dan gelen
//tüm verileri göstermek istemediğimiz için çünkü çok fazla api dan veri gelebiliyor o yüzden domain layer'daki model'e yani kullanıcıya göstermek istediğimiz
//verileri , modeli oraya yazıyoruz. Örneğin bunun verilerinde biz " type " ve " is_new " i göstermek istemiyoruz o yüzden orda ki modelde bu ikisi yok.

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

//aslında CoinDto ile aynı verilere sahip sadece birkaç veri eksik şekli gibi düşünülebilir.

//Bunlara kotlinde extension fonksiyon deniyor
fun CoinDto.toCoin() : Coin {
    return Coin(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}