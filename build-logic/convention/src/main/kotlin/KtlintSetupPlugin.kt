import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class KtlintSetupPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.pluginManager.apply("org.jlleitschuh.gradle.ktlint")
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
            }

            configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
//    version.set("0.22.0")
                debug.set(true)
                verbose.set(true)
                android.set(false)
                outputToConsole.set(true)
                outputColorName.set("RED")
                ignoreFailures.set(true)
                enableExperimentalRules.set(true)
            }
        }
    }
}
