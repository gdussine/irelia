plugins{
    id("java")
    id("maven-publish")
    id("application")
    id("com.github.ben-manes.versions") version "0.54.0"
}

group = "io.gdussine"
version = "1.1.3"

repositories{
    mavenCentral()
}

application {
    mainClass.set("irelia.tools.Launcher")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
    }
}

dependencies{
    implementation(libs.jackson.core)
    implementation(libs.slf4j.api)
    runtimeOnly(libs.logback.classic)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
    testRuntimeOnly (libs.logback.classic)
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed", "standardOut", "standardError")
        showExceptions = true
        showCauses = true
        showStackTraces = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showStandardStreams = true
    }
}
