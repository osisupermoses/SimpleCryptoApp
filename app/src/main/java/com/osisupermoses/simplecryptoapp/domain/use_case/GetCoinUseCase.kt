package com.osisupermoses.simplecryptoapp.domain.use_case

import com.osisupermoses.simplecryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(coinId: String) = repository.getCoinById(coinId)
}