package com.propokeignintion.cardrules.ui.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.propokeignintion.cardrules.domain.repository.SharedRepository
import com.propokeignintion.cardrules.domain.utils.URL
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedRepository: SharedRepository
) : ViewModel() {
    private var _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        checkAccess()
        viewModelScope.launch {
            val isSound = sharedRepository.getSound()
            _state.value.copy(
                isSoundOn = isSound,
                //isInternet = sharedRepository.checkConnect()
            )
                .updateStateUI()
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

    private fun checkAccess() {
        val client = OkHttpClient()
        val request = Request
            .Builder()
            .url(URL)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                _state.value.copy(
                    isInternet = false
                )
                    .updateStateUI()
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.code > 400) {
                    _state.value.copy(
                        isInternet = false
                    )
                        .updateStateUI()
                } else {
                    _state.value.copy(
                        isInternet = true
                    )
                        .updateStateUI()
                }
            }

        })
    }

    private fun MainState.updateStateUI() {
        _state.update {
            this
        }
    }
}