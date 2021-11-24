package com.prime.amplitude

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext as using


/**
 * Alloc code
 */
const val FRAME_ALLOC_CODE = 10
const val PACKET_ALLOC_CODE = 11
const val CODEC_CONTEXT_ALLOC_CODE = 12

/**
 * IO code
 */
const val FILE_OPEN_IO_CODE = 20
const val FILE_NOT_FOUND_IO_CODE = 21
const val INVALID_RAW_RESOURCE_IO_CODE = 22
const val NO_INPUT_FILE_IO_CODE = 23
const val INVALID_AUDIO_URL_IO_CODE = 24
const val EXTENDED_PROCESSING_DISABLED_IO_CODE = 25

/**
 * Processing code
 */
const val CODEC_NOT_FOUND_PROC_CODE = 30
const val STREAM_NOT_FOUND_PROC_CODE = 31
const val STREAM_INFO_NOT_FOUND_PROC_CODE = 32
const val CODEC_PARAMETERS_COPY_PROC_CODE = 33
const val PACKET_SUBMITTING_PROC_CODE = 34
const val CODEC_OPEN_PROC_CODE = 35
const val UNSUPPORTED_SAMPLE_FMT_PROC_CODE = 36
const val DECODING_PROC_CODE = 37
const val INVALID_PARAMETER_FLAG_PROC_CODE = 38
const val SECOND_OUT_OF_BOUNDS_PROC_CODE = 39
const val SAMPLE_OUT_OF_BOUNDS_PROC_CODE = 40

class Amplitude {

    /**
     * Computes Amplitudes on [Dispatchers.IO] thread.
     * @throws AmplitudeException
     */
    suspend fun compute(path: String): Result =
        using(Dispatchers.Default) {
            amplitudesFromJNI(path, 1, 1).also {
                check(it.errors)
            }
        }


    /**
     * Checks if some sort of exception might have occurred.
     * @throws AmplitudeException
     */
    private fun check(errors: String) {
        if (errors.isEmpty()) return
        errors.split("").forEach { error ->
            if (error.isNotEmpty()) {
                val code = error.toInt()
                val msg = when (code) {
                    FRAME_ALLOC_CODE -> "Frame Allocation exception"
                    PACKET_ALLOC_CODE -> "Packet Allocation Exception"
                    CODEC_CONTEXT_ALLOC_CODE -> "Codec Context Allocation Exception"
                    FILE_OPEN_IO_CODE -> "File Open Exception"
                    CODEC_NOT_FOUND_PROC_CODE -> "Codec Not Found Exception"
                    STREAM_NOT_FOUND_PROC_CODE -> "Stream Not Found Exception"
                    STREAM_INFO_NOT_FOUND_PROC_CODE -> "Stream Information Not Found Exception"
                    CODEC_PARAMETERS_COPY_PROC_CODE -> "Codec Parameters Exception"
                    PACKET_SUBMITTING_PROC_CODE -> "Packet Submitting Exception"
                    CODEC_OPEN_PROC_CODE -> "Codec Open Exception"
                    UNSUPPORTED_SAMPLE_FMT_PROC_CODE -> "Unsupported Sample Format Exception"
                    DECODING_PROC_CODE -> "Decoding Exception"
                    SAMPLE_OUT_OF_BOUNDS_PROC_CODE -> "Sample Out Of Bounds Exception"
                    else -> "Unknown exception"
                }
                throw AmplitudeException(msg, code)
            }
        }
    }


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