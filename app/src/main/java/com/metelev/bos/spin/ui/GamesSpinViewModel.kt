package com.metelev.bos.spin.ui

import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.metelev.bos.spin.domain.AppState
import kotlinx.coroutines.*
import java.util.*

class GamesSpinViewModel : ViewModel(), LifecycleObserver, CoroutineScope by MainScope() {

    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData()
    private var numberResult: Int = 0
    var lastSpin = -1

    fun getLiveData() = liveDataToObserve

    fun getResult(result: Int) = getData(result)
    fun getFormula(pivotX: Float, pivotY: Float, random: Int) = getFormulaResult(pivotX, pivotY, random)

    private fun getFormulaResult(pivotX: Float, pivotY: Float,random: Int) {
        val animation: Animation = RotateAnimation(
            (if (lastSpin == -1) 0 else lastSpin).toFloat(),
            random.toFloat(), pivotX, pivotY
        )
        lastSpin = random
        animation.duration = 2000
        animation.fillAfter = true
        liveDataToObserve.value = AppState.Spin(animation)
    }

    private fun getData(result: Int) {
        liveDataToObserve.value = AppState.Loading
        launch {
            delay(2000)
            if (result in 331..360) {
                numberResult = 4
            }
            if (result in 301..330){
                numberResult = 5
            }
            if (result in 271..300) {
                numberResult = 6
            }
            if (result in 241..270) {
                numberResult = 7
            }
            if (result in 211..240) {
                numberResult = 8
            }
            if (result in 181..210) {
                numberResult = 9
            }
            if (result in 151..180) {
                numberResult = 10
            }
            if (result in 120..150) {
                numberResult = 11
            }
            if (result in 90..120) {
                numberResult = 12
            }
            if (result in 60..90) {
                numberResult = 1
            }
            if (result in 30..60) {
                numberResult = 2
            }
            if (result in 0..30) {
                numberResult = 3
            }
            liveDataToObserve.value = AppState.Success(numberResult)
        }
    }
}