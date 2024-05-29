plugins {
    `kotlin-dsl`
}

group = "com.yuuta.zardapp.buildlogic"

// Configure the build-logic plugins to target JDK 17
// This matches the JDK used to build the project, and is not related to what is running on device.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    implementation("org.jlleitschuh.gradle:ktlint-gradle:12.1.0")
}

gradlePlugin {
    plugins {
        register("ktlintSetupPlugin") {
            id = "com.yuuta.zardapp.buildlogic.ktlintSetupPlugin"
            implementationClass = "KtlintSetupPlugin"
        }
    }
}
