package com.prime.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.prime.amplitude.Amplitude
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val amplitude = Amplitude()
            val list = contentResolver.Audios

            val start = System.currentTimeMillis()
            val res by amplitude.compute(list.last())
            Log.i(TAG, "onCreate: $res")
            val elapsed = System.currentTimeMillis() - start
            Log.i(TAG, "onCreate: $elapsed")
        }
    }
}