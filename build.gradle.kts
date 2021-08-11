import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
    }
    repositories.addCoreRepos()

    dependencies {
        classpath(kotlin("gradle-plugin", RootDependencies.Versions.kotlin))
        classpath(ClasspathDependencies.gradle)
        classpath(ClasspathDependencies.hilt)
        classpath(ClasspathDependencies.navigation)
        classpath(ClasspathDependencies.spotless)
    }
}

allprojects {
    repositories.addModuleRepos()

    plugins.apply(PluginDependencies.SPOTLESS)

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"

        // For experimental coroutine features like StateFlow (it's coming).
        kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
        kotlinOptions.freeCompilerArgs += "-Xuse-experimental=kotlinx.coroutines.FlowPreview"
    }
}
