import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    java
    `maven-publish`
    kotlin("jvm") version "1.7.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "ru.iamdvz"
version = "1.0-SNAPSHOT"
description = "DivizionCore"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
    maven(url = "https://jitpack.io")
    maven(url = "https://oss.sonatype.org/content/groups/public/")
    maven(url = "https://repo.codemc.org/repository/maven-public/")
    maven(url = "https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    shadow(kotlin("stdlib-jdk8"))
    compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")
    implementation("com.elmakers.mine.bukkit:EffectLib:9.4")
    shadow("com.elmakers.mine.bukkit:EffectLib:9.4")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("DivizionCore-${version}.jar")
    relocate("de.slikey", "ru.iamdvz.core.api.shaded.slikey")
    //relocate("kotlin", "ru.iamdvz.core.shaded.kotlin")
    relocate("org.intellij", "ru.iamdvz.core.shaded.intellij")
    relocate("org.jetbrains", "ru.iamdvz.core.shaded.jetbrains")
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
