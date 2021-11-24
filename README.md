[![GitHub version](https://badge.fury.io/gh/zikrt%2Famplitude.svg)](https://badge.fury.io/gh/zikrt%2Famplitude)
# Amplitude

## How to add

Add below lines in your root build.gradle at the end of repositories

``` groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Add the dependency to your app build.gradle file

``` groovy
dependencies {
    implementation  'com.github.massoudss:waveformSeekBar:4.1.0'

    // Amplitude will allow you to call setSampleFrom() with files, URLs and resources
    // Important: Only works with api level 21 and higher
    implementation 'com.github.lincollincol:amplituda:2.1.0' // or newer version
}
```

And then sync your gradle.
