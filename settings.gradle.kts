import java.util.Properties

pluginManagement {
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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven { url = uri("https://jitpack.io") }
        maven {
            val ghUsername = System.getenv("GH_USERNAME") ?: getLocalProperty("GH_USERNAME")
            val ghPassword = System.getenv("GH_TOKEN") ?: getLocalProperty("GH_TOKEN")
            url = uri("https://maven.pkg.github.com/$ghUsername/REPOSITORY")
            credentials {
                username = ghUsername
                password = ghPassword
            }
        }
    }
    versionCatalogs {
        create("mobilex") {
            from("vn.core.libs:versions:1.0.2")
        }
    }
}

fun getLocalProperty(propertyName: String): String {
    val localProperties = Properties().apply {
        val localPropertiesFile = File(rootDir, "local.properties")
        if (localPropertiesFile.exists()) {
            load(localPropertiesFile.inputStream())
        }
    }

    return localProperties.getProperty(propertyName) ?: run {
        throw NoSuchFieldException("Not defined property: $propertyName")
    }
}

rootProject.name = "finance-statistic"
include(":demo")
include(":statistic")
include(":statistic:presentation")
include(":statistic:business")
include(":statisticApi")
