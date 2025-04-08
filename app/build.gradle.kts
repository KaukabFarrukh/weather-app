plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}


    android {
    namespace = "com.kaukabfarrukh.weathertrack"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kaukabfarrukh.weathertrack"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
implementation ("androidx.core:core-ktx:1.6.0")
implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.6.10")

// Compose UI
implementation ("androidx.compose.ui:ui:1.1.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.1.1")
    implementation ("androidx.compose.material:material:1.1.1")


    debugImplementation ("androidx.compose.ui:ui-tooling:1.1.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.1.1")
    implementation ("com.google.android.material:material:1.4.0")






// Lifecycle and ViewModel
implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")



// Navigation
implementation ("androidx.navigation:navigation-compose:2.4.0")



// Retrofit for network operations
implementation ("com.squareup.retrofit2:retrofit:2.9.0")
implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

// Testing
testImplementation ("junit:junit:4.13.2")
androidTestImplementation ("androidx.test.ext:junit:1.1.3")
androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

// Compose Tooling
debugImplementation ("androidx.compose.ui:ui-tooling:1.0.1")
androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.0.1")
}
