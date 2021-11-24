package com.prime.amplitude

import android.util.Log
import kotlin.reflect.KProperty

private const val TAG = "Result"

/**
 * The result of the [Amplitude]
 */
class Result {
    /**
     * The errors which might have occured during the processing of [Audio] file
     */
    internal val errors: String = ""

    private val duration: Double = 0.0

    private val amplitudes: String = ""

    /**
     * Returns [amplitudes] as [IntArray]
     */
    val amps: IntArray
        get() {
            val values = amplitudes.split("\n")
            val array = IntArray(values.size)
            values.forEachIndexed { index, value ->
                if (value.isNotEmpty()) {
                    array[index] = value.toInt()
                } else
                    Log.i(TAG, " empty index: $index: $value")
            }
            return array
        }

    /**
     * Permits property delegation of `val`s using `by` for [Result].
     */
    @Suppress("NOTHING_TO_INLINE")
    operator fun getValue(thisObj: Any?, property: KProperty<*>): String = amplitudes

    /**
     * Returns the amplitudes as intArray.
     */
    operator fun component1(): IntArray {
        return amps
    }

    /**
     * Returns the duration of the audio file.
     */
    operator fun component2(): Long {
        return duration.toLong()
    }
}