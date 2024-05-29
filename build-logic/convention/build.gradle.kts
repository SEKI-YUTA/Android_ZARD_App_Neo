plugins {
    `kotlin-dsl`
}

group = "com.yuuta.zardapp.buildlogic"

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
