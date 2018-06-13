<img align="center" src='https://github.com/balrampandey19/android-navigation-architecture-component/blob/master/banner.png' width='400' height='500'/>

# Android Navigation Architecture Component

The Navigation Architecture Component helps you easily implement common, but complex navigation requirements, while also helping you visualize your app's navigation flow. The library provides a number of benefits, including:

* Handling fragment transactions
* Handling up and back correctly by default
* Provides defaults for animations and transitions
* Deep linking is a first class operation
* Navigation UI patterns like navigation drawers and bottom nav with little additional work
* Type safety when passing information while navigating
* Android Studio offers tooling for visualizing and editing the navigation flow of an app

## Setup

<b>1-</b> Install latest Android Studio 3.2 Canary 14 or above.

<b>2-</b>  Add navigation dependencies.

Make sure you added google() project build.gradle

```
buildscript {

    ext {
        kotlinVersion = '1.2.41'
    }
    repositories {
        google()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.2.0-alpha16'
        classpath 'android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0-alpha01'
    }
}

allprojects {
    repositories {
        google()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

ext {
    navigationVersion = "1.0.0-alpha01"
    constraintLayoutVersion = "1.1.0"
}
```

and add library dependencies for android navigation component in app build.gradle.
```
  
  implementation 'android.arch.navigation:navigation-fragment:' + rootProject.navigationVersion
  
  implementation 'android.arch.navigation:navigation-ui:' + rootProject.navigationVersion
    
```
 and add plugin in your app build.gradle.
 
 ```
 apply plugin: 'androidx.navigation.safeargs'
 
```

