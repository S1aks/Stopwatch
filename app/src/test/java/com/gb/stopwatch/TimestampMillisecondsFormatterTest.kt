package com.gb.stopwatch

import com.gb.stopwatch.viewmodel.TimestampMillisecondsFormatter
import org.junit.Assert.*
import org.junit.Test

class TimestampMillisecondsFormatterTest {
    private val timestampMillisecondsFormatter = TimestampMillisecondsFormatter()

    @Test
    fun timestampFormatTest1() {
        assertEquals(timestampMillisecondsFormatter.format(0L), "00:00:000")
    }

    @Test
    fun timestampFormatTest2() {
        assertEquals(timestampMillisecondsFormatter.format(82107750L), "22:48:27")
    }

    @Test
    fun timestampFormatTest3() {
        assertEquals(timestampMillisecondsFormatter.format(83107750L), "23:05:07")
    }

    @Test
    fun timestampFormatTest4() {
        assertNotEquals(timestampMillisecondsFormatter.format(83107750L), "")
    }

    @Test
    fun timestampFormatTest5() {
        assertNotNull(timestampMillisecondsFormatter.format(83107750L))
    }
}