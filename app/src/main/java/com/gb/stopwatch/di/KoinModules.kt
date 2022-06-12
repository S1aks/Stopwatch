package com.gb.stopwatch.di

import com.gb.stopwatch.model.TimestampProviderImpl
import com.gb.stopwatch.model.data.TimestampProvider
import com.gb.stopwatch.view.MainViewModel
import com.gb.stopwatch.viewmodel.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<TimestampProvider> { TimestampProviderImpl() }
    single { TimestampMillisecondsFormatter() }
    single { ElapsedTimeCalculator(timestampProvider = get()) }
    single { StopwatchStateCalculator(timestampProvider = get(), elapsedTimeCalculator = get()) }
    factory {
        StopwatchStateHolder(stopwatchStateCalculator = get(),
            elapsedTimeCalculator = get(),
            timestampMillisecondsFormatter = get())
    }
    factory {
        StopwatchListOrchestrator(stopwatchStateHolder = get(),
            CoroutineScope(Dispatchers.Default + SupervisorJob()))
    }
    viewModel {
        MainViewModel(stopwatchListOrchestrator1 = get(),
            stopwatchListOrchestrator2 = get())
    }
}