package com.gb.stopwatch.model

import com.gb.stopwatch.model.data.TimestampProvider

class TimestampProviderImpl : TimestampProvider {
    override fun getMilliseconds(): Long = System.currentTimeMillis()
}