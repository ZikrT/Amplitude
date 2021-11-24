package com.prime.amplitude

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext as using

class Amplitude {

    suspend fun compute(path: String): Result =
        using(Dispatchers.Default) { amplitudesFromJNI(path, 1, 1) }

    private external fun amplitudesFromJNI(
        path: String,
        compressionType: Int,
        fps: Int,
    ): Result

    companion object {
        // Used to load the 'amplitude' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}