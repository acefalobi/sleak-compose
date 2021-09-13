@file:Suppress("KDocMissingDocumentation")

import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.maven
import java.util.Properties

object BuildConfiguration {
    const val targetSdkVersion = 30
    const val compileSdkVersion = 30
    const val minSdkVersion = 21

    const val versionCode = 1
    const val versionName = "1.0.0"

    const val applicationId = "com.aceinteract.sleak"
}

fun getEnvProperty(properties: Properties, name: String): String =
    System.getenv(name) ?: properties.getProperty(name)
    ?: error("Unable to get $name from Environment Variables or local.properties")

fun RepositoryHandler.addCoreRepos() {
    google()
    mavenCentral()
}

fun RepositoryHandler.addModuleRepos() {
    addCoreRepos()
    maven("https://jitpack.io")
}