plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id(PluginDependencies.HILT)
    id(PluginDependencies.NAVIGATION)
}

android {
    compileSdk = BuildConfiguration.compileSdkVersion

    defaultConfig {
        applicationId = BuildConfiguration.applicationId

        minSdk = BuildConfiguration.minSdkVersion
        targetSdk = BuildConfiguration.targetSdkVersion

        versionCode = BuildConfiguration.versionCode
        versionName = BuildConfiguration.versionName

        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        setProperty("archivesBaseName", "$applicationId-app-$versionName")
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isDebuggable = true

            resValue("string", "app_name", "Sleak Debug")
        }
        getByName("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            resValue("string", "app_name", "Sleak")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }

    lint {
        isCheckAllWarnings = true
        isWarningsAsErrors = true
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(RootDependencies.kotlin)

    implementation(project(ProjectDependencies.core))
    implementation(project(ProjectDependencies.local))
    implementation(project(ProjectDependencies.remote))

    implementation(DependencyInjectionDependencies.hilt)
    implementation(DependencyInjectionDependencies.hiltComposeNavigation)
    kapt(DependencyInjectionDependencies.hiltCompiler)

    implementation(AndroidXDependencies.activityCompose)
    implementation(AndroidXDependencies.appCompat)
    implementation(AndroidXDependencies.composeUI)
    implementation(AndroidXDependencies.composeMaterial)
    implementation(AndroidXDependencies.composeMaterialIcons)
    implementation(AndroidXDependencies.composePreview)
    implementation(AndroidXDependencies.composeTooling)
    implementation(AndroidXDependencies.lifecycleCommon)
    implementation(AndroidXDependencies.lifecycleRuntime)
    implementation(AndroidXDependencies.lifecycleViewModel)
    implementation(AndroidXDependencies.navigationFragmentKtx)
    implementation(AndroidXDependencies.navigationUiKtx)

    implementation(ViewDependencies.coil)
    implementation(ViewDependencies.exoPlayer)
    implementation(ViewDependencies.materialComponent)
    implementation(ViewDependencies.shimmerLayout)

    implementation(PersistenceDependencies.room)

    implementation(AsyncDependencies.coroutines)
    implementation(AsyncDependencies.coroutinesAndroid)

    implementation(UtilityDependencies.accompanistInsets)
    implementation(UtilityDependencies.accompanistInsetsUi)
    implementation(UtilityDependencies.accompanistSwipeRefresh)
    implementation(UtilityDependencies.moshi)
    implementation(UtilityDependencies.timber)

    testImplementation(TestingDependencies.jUnit)
    testImplementation(TestingDependencies.mockitoCore)
    testImplementation(TestingDependencies.roboelectric)
    androidTestImplementation(TestingDependencies.androidJUnit)
    testImplementation(TestingDependencies.androidTest)
    androidTestImplementation(TestingDependencies.androidTestRunner)
}
