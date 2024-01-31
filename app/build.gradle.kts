plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.mvvm_project_example_sec16"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mvvm_project_example_sec16"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        //TMDB API KEY
        android.buildFeatures.buildConfig =  true
        buildConfigField("String","API_KEY","\"64e6427af709af8737f5763315ea0502\"")
        buildConfigField("String","BASIC_URL","\"https://api.themoviedb.org/3/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    dataBinding {
        enable=true
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //-----------------------------
    val lifecycle_version = "2.6.2"
    // 1- ViewModel LiveData
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    // Annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    // 2- Room
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    // 3- Coroutines
    val coroutines_version = "1.8.0-RC"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")

    // 4- Dagger
    val dagger_version = "2.49"
    implementation ("com.google.dagger:dagger:$dagger_version")
    kapt ("com.google.dagger:dagger-compiler:$dagger_version")
    implementation ("com.google.dagger:dagger-android:$dagger_version")
    kapt  ("com.google.dagger:dagger-android-processor:$dagger_version")
    implementation ("com.google.dagger:dagger-android-support:$dagger_version")
    kapt  ("com.google.dagger:dagger-android-support:2.49")

    // 5- Retrofit
    val retrofit2_version ="2.9.0"
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    val logging_interceptor = "4.11.0"
    implementation("com.squareup.okhttp3:logging-interceptor:$logging_interceptor")

    // 6- Glide
    val glide_version = "4.16.0"
    implementation("com.github.bumptech.glide:glide:$glide_version")


}