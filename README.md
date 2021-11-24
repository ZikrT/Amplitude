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
     implementation 'com.github.zikrt:amplitude:latest_version'
}
```

And then sync your gradle.
