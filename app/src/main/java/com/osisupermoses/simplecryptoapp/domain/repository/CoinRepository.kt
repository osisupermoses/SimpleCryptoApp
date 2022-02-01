package com.osisupermoses.simplecryptoapp.domain.repository

import com.osisupermoses.simplecryptoapp.common.Resource
import com.osisupermoses.simplecryptoapp.domain.model.Coin
import com.osisupermoses.simplecryptoapp.domain.model.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins(): Flow<Resource<List<Coin>>>

    suspend fun getCoinById(coinId: String): Flow<Resource<CoinDetail>>
}