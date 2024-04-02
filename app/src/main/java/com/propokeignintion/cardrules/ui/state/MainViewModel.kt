package com.propokeignintion.cardrules.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.propokeignintion.cardrules.domain.repository.SharedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedRepository: SharedRepository
) : ViewModel() {
    private var _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val isSound = sharedRepository.getSound()
            _state.value.copy(
                isSoundOn = isSound
            )
                .updateStateUI()
            if (sharedRepository.checkConnect()) {
                _state.value.copy(
                    startScreenState = StartScreenState.Web
                )
                    .updateStateUI()
            } else {
                _state.value.copy(
                    startScreenState = StartScreenState.Mock
                )
                    .updateStateUI()
            }
        }
    }

    fun onEvent(event: MainEvent) {
        when (event) {

            MainEvent.SetSound -> {
                _state.value.copy(
                    isSoundOn  = !_state.value.isSoundOn
                )
                    .updateStateUI()
                viewModelScope.launch {
                    sharedRepository.setSound(_state.value.isSoundOn)
                }
            }
        }
    }


    private fun MainState.updateStateUI() {
        _state.update {
            this
        }
    }
}