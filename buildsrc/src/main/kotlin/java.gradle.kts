package hu.bme.mit.ase.shingler.gradle
// this is the plugin used for java projects
plugins {
    java
    jacoco
    `java-library`

}

java.toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
}

repositories {
    mavenCentral()
}

tasks {
    test {
        useJUnitPlatform()
        testLogging.showStandardStreams = true
        finalizedBy(jacocoTestReport)
    }

    jacocoTestReport {
        inputs.files(test.get().outputs)
    }
}

