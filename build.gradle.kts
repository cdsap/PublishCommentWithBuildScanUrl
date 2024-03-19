// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
}
println(providers.environmentVariable("PR_CI_BUILD").isPresent)
if (providers.environmentVariable("PR_CI_BUILD").isPresent) {
    rootProject.buildScan {
        this.buildScanPublished {
            println(this.buildScanUri.toString())
            File("temp_build_scan_url.txt").writeText(this.buildScanUri.toString())
        }
    }
}
