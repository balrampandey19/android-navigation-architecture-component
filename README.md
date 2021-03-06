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

Click on Text tab, screen added in XML.

```   
<fragment
    android:id="@+id/onBoardingFragment"
        android:name="troops.com.android_navigation.OnBoardingFragment"
        android:label="fragment_on_boarding"
        tools:layout="@layout/fragment_on_boarding">
 </fragment>
 
 ```
 
 <b>3- </b>  Open your kotilin class and add this code on your button click.
 
 ```
   view.findViewById<Button>(R.id.signIn)?.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.aboutFragment, null))
  
  ```


## Navigate Using Actions

<b>1- </b> Open ``` /res/navagation/mobile_navigation.xml ```

<b>2- </b> Add action in onBoardingFragment.

```
 <action
   android:id="@+id/action_onBoardingFragment_to_signInFragment"
   app:destination="@id/signInFragment" />
            
```
Newly genrated code looks like 

```
   <fragment
        android:id="@+id/onBoardingFragment"
        android:name="troops.com.android_navigation.OnBoardingFragment"
        android:label="fragment_on_boarding"
        tools:layout="@layout/fragment_on_boarding">
        <action
            android:id="@+id/action_onBoardingFragment_to_signInFragment"
            app:destination="@id/signInFragment" />
    </fragment>
```

<b> 3- </b> Now open koltlin class and add this code on button click.

```
   view.findViewById<Button>(R.id.signUp)?.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.next_action, null)
        )
   
```

## Using type safe argument bundles for navigation

<b>1- </b> Open ``` /res/navagation/mobile_navigation.xml ```

<b>2- </b> Add this code in data receiving fragement.
```
 <argument
            android:name="data"
            app:type="string" />
  
 ```
 and newly code looks like below code.
 
 ```
 <fragment
        android:id="@+id/homeFragment"
        android:name="troops.com.android_navigation.HomeFragment"
        android:label="fragment_home"
        tools:layout="@layout/fragment_home">
        <argument
            android:name="data"
            app:type="string" />
   
   </fragment>
   
 ```
 
 <b>3- </b> Now open your sending data class and add this code.
 
 ```
  val bundle = Bundle()
        bundle.putString("data", "Android Navigation")
        button.setOnClickListener {
            Navigation.createNavigateOnClickListener(R.id.homeFragment, bundle)
        }
        
 ```
  <b>4- </b> Now open your receiving data class and add this code.
  
  ```
    val username = arguments?.let {
            val safeArgs = HomeFragmentArgs.fromBundle(it)
            safeArgs.data
        }
        nameTextx.text = username;
        
   ```

## Deep Linking to a destination

Deep Links and Navigation
Navigation components also include deep link support. Deep links are a way to jump into the middle of your app's navigation, whether that's from an actual url link or a pending intent from a notification.

One benefit of using the navigation library to handle deep links is that it ensures users start on the appropriate destination with the appropriate back stack from other entry points such as app widgets, notifications, or web links (covered in the next step).

Navigation provides a NavDeepLinkBuilder class to construct a PendingIntent that will take the user to a specific destination.

### Add a Deep Link

<b>1- </b> Open ``` /res/navagation/mobile_navigation.xml ```

<b>2- </b> Add deep link with URL in your destination screen.

```
        <deepLink app:uri="www.example.com/home" />

```
and newly genrated code looks like.

```
 <fragment
        android:id="@+id/homeFragment"
        android:name="troops.com.android_navigation.HomeFragment"
        android:label="fragment_home"
        tools:layout="@layout/fragment_home">
        <argument
            android:name="data"
            app:type="string" />
        <deepLink app:uri="www.example.com/home" />

    </fragment>
    
  ```
  
  <b>3- </b> Open ```AndroidManifest```
  
  <b>4- </b> Add ```<nav-graph>```
  
  ```
              <nav-graph android:value="@navigation/mobile_navigation" />
```


## Supporting Links

https://codelabs.developers.google.com/codelabs/android-navigation/index.html?index=..%2F..%2Findex#10

https://developer.android.com/topic/libraries/architecture/navigation/

https://developer.android.com/topic/libraries/architecture/navigation/navigation-migrate

https://developer.android.com/topic/libraries/architecture/navigation/navigation-migrate


# Contributing

Please feel free to fork this repository and create pull request, and also if you have any issue or question regarding Android Navigation create a issue i will try to help.

#### Thanks


