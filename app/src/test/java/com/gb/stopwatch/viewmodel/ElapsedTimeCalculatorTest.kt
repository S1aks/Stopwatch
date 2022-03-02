package com.gb.stopwatch.viewmodel

import com.gb.stopwatch.model.data.StopwatchState
import com.gb.stopwatch.model.data.TimestampProvider
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class ElapsedTimeCalculatorTest {

    private lateinit var elapsedTimeCalculator: ElapsedTimeCalculator

    @Mock
    private lateinit var timestampProvider: TimestampProvider

    @Mock
    private lateinit var state: StopwatchState.Running

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        elapsedTimeCalculator = ElapsedTimeCalculator(timestampProvider = timestampProvider)
        Mockito.`when`(timestampProvider.getMilliseconds()).thenReturn(1000L)
        Mockito.`when`(state.startTime).thenReturn(500L)
        Mockito.`when`(state.elapsedTime).thenReturn(0L)
    }

    @Test
    fun testCalculateReturnNotNull() {
        Assert.assertNotNull(elapsedTimeCalculator.calculate(state = state))
    }

    @Test
    fun testCalculateReturnResult() {
        Assert.assertEquals(500L, elapsedTimeCalculator.calculate(state = state))
    }

    @Test
    fun testCalculateGetCurrentTime() {
        elapsedTimeCalculator.calculate(state = state)
        verify(timestampProvider).getMilliseconds()
    }
}