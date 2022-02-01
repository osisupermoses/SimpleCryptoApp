package com.osisupermoses.simplecryptoapp.presentation.coin_list

import com.osisupermoses.simplecryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
