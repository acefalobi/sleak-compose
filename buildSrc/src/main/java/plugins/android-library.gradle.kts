package plugins

import AsyncDependencies
import BuildConfiguration
import DependencyInjectionDependencies
import ProjectDependencies
import RootDependencies
import TestingDependencies
import UtilityDependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildConfiguration.compileSdkVersion

    @Suppress("UnstableApiUsage")
    defaultConfig {
        minSdk = BuildConfiguration.minSdkVersion
        targetSdk = BuildConfiguration.targetSdkVersion
    }

    compileOptions.sourceCompatibility = JavaVersion.VERSION_1_8
    compileOptions.targetCompatibility = JavaVersion.VERSION_1_8

    lintOptions.isCheckAllWarnings = true
    lintOptions.isWarningsAsErrors = true

    testOptions.unitTests.isIncludeAndroidResources = true
    testOptions.unitTests.isReturnDefaultValues = true

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
}

dependencies {
    implementation(RootDependencies.kotlin)
    implementation(project(ProjectDependencies.core))

    implementation(AsyncDependencies.coroutines)
    implementation(AsyncDependencies.coroutinesAndroid)

    implementation(UtilityDependencies.timber)

    implementation(DependencyInjectionDependencies.hilt)
    kapt(DependencyInjectionDependencies.hiltCompiler)

    testImplementation(AsyncDependencies.coroutinesTest)

    testImplementation(TestingDependencies.assertJ)
    testImplementation(TestingDependencies.jUnit)
}

kapt {
    correctErrorTypes = true
}
