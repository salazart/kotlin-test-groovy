plugins {
    // Apply the groovy plugin to add support for Groovy
    groovy

    // Apply the application plugin to add support for building an application
    application
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // Use the latest Groovy version for building this library
    implementation("org.codehaus.groovy:groovy-all:2.5.4")

    // Use the awesome Spock testing and specification framework
    testImplementation("org.spockframework:spock-core:1.2-groovy-2.5")
}

application {
    // Define the main class for the application
    mainClassName = "com.sz.ktg.App"
}
