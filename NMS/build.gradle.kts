plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "me.g2213swo"
version = "0.0.1"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

