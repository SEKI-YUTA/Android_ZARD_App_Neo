pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        
    }
}

rootProject.name = "ZARDAppNeo"
include(":app")
include(":feature:trackList")
include(":feature:setting")
include(":feature:discList")
include(":feature:discDetail")
include(":core:ui")
include(":resource")
include(":common")
include(":navigation")
include(":app-constant")
include(":screenshotTest")
