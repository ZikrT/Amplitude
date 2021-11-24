package com.prime.amplitude

class AmplitudeException(message: String, val code: Int) : Exception(
    String.format(
        "%s\nRead Amplitude doc here: https://github.com/lincollincol/Amplituda",
        message
    )
) 