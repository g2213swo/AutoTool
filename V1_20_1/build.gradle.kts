plugins {
    `java-library`
    id("io.papermc.paperweight.userdev") version "1.5.5"
    id("xyz.jpenilla.run-paper") version "2.1.0"
}

group = "me.g2213swo"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")

    compileOnly(project(":NMS"))
}

tasks.test {
    useJUnitPlatform()
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }
}
