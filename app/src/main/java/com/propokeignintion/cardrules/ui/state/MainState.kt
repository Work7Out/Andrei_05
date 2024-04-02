package com.propokeignintion.cardrules.ui.state

data class MainState (
    val isSoundOn: Boolean = true,
    val startScreenState: StartScreenState = StartScreenState.Loading
)


sealed interface StartScreenState {
    data object Loading:StartScreenState
    data object Mock:StartScreenState
    data object Web:StartScreenState
}