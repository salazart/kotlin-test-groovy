plugins {
    groovy
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:2.5.4")
    testImplementation("junit:junit:4.12")
    testImplementation("org.powermock:powermock-module-junit4:2.0.0")
    testImplementation("org.spockframework:spock-core:1.2-groovy-2.5")
}
