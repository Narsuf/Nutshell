import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.safe.args)
    alias(libs.plugins.google.services)
    alias(libs.plugins.crashlytics)
    alias(libs.plugins.paparazzi)
    alias(libs.plugins.kotlin.compose)
    jacoco
}

//region Jacoco
jacoco { toolVersion = "0.8.12" }

val exclusions = listOf(
    "**/*Test*.*",
    "**/*Robot*.*",
)

tasks.withType(Test::class) {
    configure<JacocoTaskExtension> {
        isIncludeNoLocationClasses = true
        excludes = listOf("jdk.internal.*")
    }
}
//endregion

val properties = Properties().apply {
    load(rootProject.file("constants.properties").inputStream())
}

android {
    val sdkV = properties.getProperty("sdkV").toInt()

    namespace = "org.n27.nutshell"
    compileSdk = sdkV

    defaultConfig {
        applicationId = "org.n27.nutshell"
        minSdk = properties.getProperty("minSdkV").toInt()
        targetSdk = sdkV
        versionCode = 9
        versionName = "1.0.4-debug"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            enableUnitTestCoverage = true
            enableAndroidTestCoverage = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions { jvmTarget = "1.8" }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions { kotlinCompilerExtensionVersion = "1.5.3" }

    testOptions {
        unitTests { isIncludeAndroidResources = true }
    }

    tasks.register<JacocoReport>("jacocoTestReport") {
        dependsOn("testDebugUnitTest", "createDebugCoverageReport")

        reports {
            xml.required.set(true)
            html.required.set(true)
        }

        val debugTree = fileTree(layout.buildDirectory.dir("intermediates/javac/")) {
            exclude(exclusions)
        }

        val kotlinDebugTree = fileTree(layout.buildDirectory.dir("tmp/kotlin-classes/")) {
            exclude(exclusions)
        }

        val mainSrc = layout.projectDirectory.dir("src/main")

        sourceDirectories.setFrom(files(mainSrc))
        classDirectories.setFrom(files(debugTree, kotlinDebugTree))
        executionData.setFrom(files(
            fileTree(layout.buildDirectory) {
                include(listOf("**/*.exec", "**/*.ec"))
            }
        ))
    }
}

dependencies {
    api(libs.kotlinx.collections.immutable)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)

    // Compose
    val composeBom = platform("androidx.compose:compose-bom:2024.06.00")
    implementation(composeBom)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.database)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)

    // Dagger 2
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    // Android Jetpack

        // Lifecycle
        implementation(libs.androidx.lifecycle.runtime.compose)

        // Navigation
        implementation(libs.androidx.navigation.fragment.ktx)
        implementation(libs.androidx.navigation.ui.ktx)
        implementation(libs.androidx.navigation.compose)

    // Coil
    implementation(libs.coil.compose)

    // Lottie
    implementation(libs.lottie)

    testImplementation(libs.junit)
    testImplementation(libs.androidx.core)
    testImplementation(libs.mockito.inline)
    testImplementation(libs.robolectric)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(project(":test_data"))

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(project(":test_data"))
}
