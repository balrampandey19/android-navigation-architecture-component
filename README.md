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
## Using android navigation architecture component

Before going forward you need to know about most important componet of navigation architecture that is <b>Navigatio Graph</b>.

### Navigation Graph

The different places that you can navigate to from a destination are represented visually in a navigation graph. This is a new resource type where you define all the possible paths a user could take through the app. Android Studio represents this visually for you using the new Navigation Editor.

<img align="center" src='https://github.com/balrampandey19/android-navigation-architecture-component/blob/master/navigation.png' width='800' height='500'/>

[Read more about navigation graph](https://codelabs.developers.google.com/codelabs/android-navigation/index.html?index=..%2F..%2Findex#2)

## Navigation Graph to Navigate

<b>1-</b>  create a package in res and set name "navigation"  ``` /res/navagation/mobile_navigation.xml ```

<b>2- </b> Open ``` /res/navagation/mobile_navigation.xml ``` click on design tab. and add screens in navigation graph.

<img align="center" src='https://github.com/balrampandey19/android-navigation-architecture-component/blob/master/addscreen.png' width='300' height='300'/>

Click on Text tab. and you can see screen added in XML.

```    <fragment
        android:id="@+id/aboutFragment"
        android:name="troops.com.android_navigation.AboutFragment"
        android:label="fragment_about"
        tools:layout="@layout/fragment_about">
        <deepLink app:uri="www.example.com/about" />
    </fragment>
    
    ```


