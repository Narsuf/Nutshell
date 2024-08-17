import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

val properties = Properties().apply {
    load(rootProject.file("constants.properties").inputStream())
}

android {
    val sdkV = properties.getProperty("sdkV").toInt()

    namespace = "com.n27.nutshell"
    compileSdk = sdkV

    defaultConfig {
        minSdk = properties.getProperty("minSdkV").toInt()
        targetSdk = sdkV
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions { jvmTarget = "1.8" }
}

dependencies { compileOnly(project(":app")) }