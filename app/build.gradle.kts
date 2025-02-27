plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("dagger.hilt.android.plugin")
   // id("kotlin-kapt")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.android.roomtest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.android.roomtest"
        minSdk = 26
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
//    kapt {
//        correctErrorTypes = true
//    }


    buildFeatures {
        buildConfig = true
    }




    packaging {
        resources {
            excludes += listOf(
                "META-INF/NOTICE.md",
                "META-INF/ASL-2.0.txt",
                "META-INF/LICENSE.md",
                "META-INF/INDEX.LIST",
                "META-INF/io.netty.versions.properties",
                "/META-INF/{AL2.0,LGPL2.1}",
                "META-INF/retrofit.kotlin_module"
            )
        }
        jniLibs {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.auth)

    // Dagger Hilt
    implementation(libs.hilt.android)
    ksp(libs.dagger.hilt.compiler)
    api(libs.androidx.hilt.navigation.fragment)

    // Hilt for instrumentation tests
    androidTestImplementation(libs.dagger.hilt.android.testing)
    kspAndroidTest(libs.dagger.hilt.compiler)

    // Hilt for Robolectric tests
    testImplementation(libs.dagger.hilt.android.testing)
    kspTest(libs.dagger.hilt.compiler)

    implementation(libs.ktor.server.host.common)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.gson)
    implementation(libs.ktor.server.cors)



    implementation(libs.kotlinx.coroutines.core) // Updated to the latest version
    implementation(libs.kotlinx.coroutines.android) // Ensure the latest version
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)


}