package com.osisupermoses.simplecryptoapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.osisupermoses.simplecryptoapp.common.Resource
import com.osisupermoses.simplecryptoapp.domain.use_case.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            getCoinsUseCase().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = CoinListState(coins = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _state.value = CoinListState(
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = CoinListState(isLoading = true)
                    }
                }
            }.launchIn(this)
        }
    }
}