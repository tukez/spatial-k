import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.detekt)
}

detekt {
    buildUponDefaultConfig = true

    source = files(
        project(":geojson").projectDir.resolve("src"),
        project(":turf").projectDir.resolve("src")
    )
}


tasks.withType<Detekt> {
    buildUponDefaultConfig = true
    jvmTarget = "1.8"
    reports {
        html.required.set(true)
    }
}
