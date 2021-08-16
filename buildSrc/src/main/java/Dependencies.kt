@file:Suppress("KDocMissingDocumentation")

object PluginDependencies {
    const val GOOGLE_SERVICES = "com.google.gms.google-services"
    const val HILT = "dagger.hilt.android.plugin"
    const val NAVIGATION = "androidx.navigation.safeargs.kotlin"
    const val SPOTLESS = "plugins.spotless"
}

object ProjectDependencies {
    const val app = ":app"

    const val common = ":common"
    const val core = ":core"

    const val local = ":local"
    const val remote = ":remote"
}

object RootDependencies {

    object Versions {
        const val kotlin = "1.5.21"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
}

object NetworkDependencies {

    object Versions {
        const val okhttp = "4.8.0"
        const val retrofit = "2.9.0"
    }

    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val retrofitMock = "com.squareup.retrofit2:retrofit-mock:${Versions.retrofit}"

}

object AndroidXDependencies {

    object Versions {
        const val activityCompose = "1.3.1"
        const val appCompat = "1.3.1"
        const val coreKtx = "1.6.0"
        const val compose = "1.0.1"
        const val lifecycle = "2.3.1"
        const val transition = "1.2.0"
        const val navigation = "2.3.0-alpha05"
        const val workManager = "2.5.0"
    }

    const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val composeUI = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterialIcons = "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val navigationFragmentKtx =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val transition = "androidx.transition:transition:${Versions.transition}"
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"
}

object ViewDependencies {

    object Versions {
        const val coil = "1.1.1"
        const val exoPlayer = "2.14.2"
        const val materialComponent = "1.4.0"
        const val shimmerLayout = "0.4.0"
    }

    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val exoPlayer = "com.google.android.exoplayer:exoplayer:${Versions.exoPlayer}"
    const val materialComponent =
        "com.google.android.material:material:${Versions.materialComponent}"
    const val shimmerLayout = "com.facebook.shimmer:shimmer:${Versions.shimmerLayout}"
}

object AsyncDependencies {

    object Versions {
        const val coroutines = "1.5.1"
    }

    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

}

object DependencyInjectionDependencies {

    object Versions {
        const val hilt = "2.36"
        const val hiltComposeNavigation = "1.0.0-alpha03"
    }

    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltComposeNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltComposeNavigation}"
}

object PersistenceDependencies {

    object Versions {
        const val room = "2.3.0"
        const val sqliteJdbc = "3.34.0"
    }

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomTest = "androidx.room:room-testing:${Versions.room}"
    const val sqliteJdbc = "org.xerial:sqlite-jdbc:${Versions.sqliteJdbc}"
}

object UtilityDependencies {

    object Versions {
        const val accompanist = "0.16.1"
        const val moshi = "1.12.0"
        const val timber = "4.7.1"
        const val multidex = "2.0.0"
    }

    const val accompanistInsets = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    const val accompanistInsetsUi = "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    const val accompanistSwipeRefresh = "com.google.accompanist:accompanist-swiperefresh:${Versions.accompanist}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"
}

object TestingDependencies {

    object Versions {
        const val androidJUnit = "1.1.2"
        const val androidTest = "1.1.0"
        const val androidTestRunner = "1.1.1"
        const val assertJ = "3.16.1"
        const val jUnit = "4.13.2"
        const val konveyor = "1.0.3"
        const val mockito = "2.25.0"
        const val mockk = "1.9.3"
        const val roboelectric = "4.3"
    }

    const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
    const val androidTest = "androidx.test:core:${Versions.androidTest}"
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    const val assertJ = "org.assertj:assertj-core:${Versions.assertJ}"
    const val jUnit = "junit:junit:${Versions.jUnit}"
    const val konveyor = "com.github.vacxe:konveyor:${Versions.konveyor}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val roboelectric = "org.robolectric:robolectric:${Versions.roboelectric}"
}

object ClasspathDependencies {

    object Versions {
        const val gradle = "7.0.0"
        const val hilt = "2.38.1"
        const val navigation = "2.3.5"
        const val spotless = "5.14.0"
    }

    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val navigation =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val spotless = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}"
}