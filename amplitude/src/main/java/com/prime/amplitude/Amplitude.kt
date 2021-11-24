package com.prime.amplitude

class Amplitude {

    fun compute(path: String) = amplitudesFromJNI(path, 1, 1)


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