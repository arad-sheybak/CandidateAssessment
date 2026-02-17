pluginManagement {
    repositories {
        // google()
        mavenCentral()

        maven {
            name = "阿里云Google镜像"
            url = uri("https://maven.aliyun.com/repository/google")
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            name = "阿里云公共镜像"
            url = uri("https://maven.aliyun.com/repository/public")
        }
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // google()
        mavenCentral()

        maven {
            name = "阿里云Google镜像"
            url = uri("https://maven.aliyun.com/repository/google")
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven {
            name = "阿里云公共镜像"
            url = uri("https://maven.aliyun.com/repository/public")
        }
    }
}

rootProject.name = "CandidateAssessment"
include(":app")