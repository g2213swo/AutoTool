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
    maven { url = uri("https://repo.william278.net/releases") }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation(project(":NMS"))
    implementation(project(":V1_20_1", configuration = "reobf"))

    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    compileOnly("net.william278:husksync:2.2.8")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}