package com.osisupermoses.simplecryptoapp.presentation.coin_detail

import com.osisupermoses.simplecryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
