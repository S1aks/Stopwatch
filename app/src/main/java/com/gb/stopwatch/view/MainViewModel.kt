package com.gb.stopwatch.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gb.stopwatch.viewmodel.StopwatchListOrchestrator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val stopwatchListOrchestrator1: StopwatchListOrchestrator,
    private val stopwatchListOrchestrator2: StopwatchListOrchestrator
) : ViewModel(), CoroutineScope by MainScope() {
    val liveData1: MutableLiveData<String> = MutableLiveData()
    val liveData2: MutableLiveData<String> = MutableLiveData()

    fun init() {
        launch {
            stopwatchListOrchestrator1.stop()
            stopwatchListOrchestrator1.ticker.collect(liveData1::postValue)
        }
        launch {
            stopwatchListOrchestrator2.stop()
            stopwatchListOrchestrator2.ticker.collect(liveData2::postValue)
        }

    }

    fun start1() = stopwatchListOrchestrator1.start()

    fun pause1() = stopwatchListOrchestrator1.pause()

    fun stop1() = stopwatchListOrchestrator1.stop()

    fun start2() = stopwatchListOrchestrator2.start()

    fun pause2() = stopwatchListOrchestrator2.pause()

    fun stop2() = stopwatchListOrchestrator2.stop()
}