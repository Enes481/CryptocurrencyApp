package com.enestigli.cryptocurrencyapp.domain.use_case.get_coin

import com.enestigli.cryptocurrencyapp.common.Resource
import com.enestigli.cryptocurrencyapp.data.remote.dto.toCoinDetail
import com.enestigli.cryptocurrencyapp.domain.model.CoinDetail
import com.enestigli.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    //use_case in içinde sadece gerekli olan tek bir fonksiyon kullanılmalı eğer biz get_coin ve get_coins usecase işlemlerinin
    //her ikisini de bir use_case e yazarsak bu kötü bir yaklaşım olur.

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {

        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()                           //Burda coindetaildto daki veriyi bizim ui da kullanmak istediğimiz coindetail e çeviriyor.
            emit(Resource.Success(coin))

        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e:IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }



}