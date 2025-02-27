plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    id("com.google.devtools.ksp") version "2.1.10-1.0.29" apply false
}

buildscript {
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
    }
}
