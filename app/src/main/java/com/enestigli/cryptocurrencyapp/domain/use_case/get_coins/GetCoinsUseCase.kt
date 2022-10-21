package com.enestigli.cryptocurrencyapp.domain.use_case.get_coins

import com.enestigli.cryptocurrencyapp.common.Resource
import com.enestigli.cryptocurrencyapp.data.remote.dto.toCoin
import com.enestigli.cryptocurrencyapp.domain.model.Coin
import com.enestigli.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    //use_case in içinde sadece gerekli olan tek bir fonksiyon kullanılmalı eğer biz get_coin ve get_coins usecase işlemlerinin
    //her ikisini de bir use_case e yazarsak bu kötü bir yaklaşım olur.

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {

        try {

            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() } //Burda coindto daki tüm verileri aslında coin e çeviriyor,map liyor.
            emit(Resource.Success(coins))

        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e:IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }



}