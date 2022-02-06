package com.metelev.bos.spin.domain

import android.view.animation.Animation

sealed class AppState {
    data class Success(val data: Int) : AppState()
    data class Spin(val spin: Animation) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
