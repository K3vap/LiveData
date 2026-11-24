plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.kevintimus.livedata"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.kevintimus.livedata"
        minSdk = 27
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.9.0")
    //LiveData
    implementation("androidx.lifecycle:lifecycle-livedata:2.9.0")
    //Fragment
    implementation("androidx.fragment:fragment-ktx:1.8.6")

}