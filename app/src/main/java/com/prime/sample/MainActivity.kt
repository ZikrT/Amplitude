package com.prime.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.prime.amplitude.Amplitude
import kotlin.concurrent.thread

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        thread {

            val amplitude = Amplitude()
            val list = contentResolver.Audios

            val start = System.currentTimeMillis()
            val res = amplitude.compute(list.last())
            Log.i(TAG, "onCreate: $res")
            val elapsed = System.currentTimeMillis() - start
            Log.i(TAG, "onCreate: $elapsed")
            Log.i(TAG, "onCreate: ")
            Log.i(TAG, "onCreate: ")
        }


    }
}