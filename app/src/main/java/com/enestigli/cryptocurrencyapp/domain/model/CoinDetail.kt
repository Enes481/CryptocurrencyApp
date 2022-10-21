package com.enestigli.cryptocurrencyapp.domain.model

import com.enestigli.cryptocurrencyapp.data.remote.dto.TeamMember


//Bu veriler bizim detail screen imizde ihtiyacımız olan veriler api dan gelen tüm verilere burda ihtiyacımız yok.
data class CoinDetail(
    val coinId:String,
    val name :String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val isActive:Boolean,
    val tags :List<String>,
    val team:List<TeamMember>
    ) {


}