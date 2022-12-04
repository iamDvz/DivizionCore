import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    java
    `maven-publish`
    kotlin("jvm") version "1.7.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "ru.iamdvz"
version = "0.1-SNAPSHOT"
description = "DivizionCore"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenLocal()
    maven(url = "https://jitpack.io")
    maven(url = "https://oss.sonatype.org/content/groups/public/")
    maven(url = "https://repo.codemc.org/repository/maven-public/")
    maven(url = "https://repo.papermc.io/repository/maven-public/")
    maven(url = "https://mvn.lumine.io/repository/maven/")
}

dependencies {
    compileOnly("me.clip:placeholderapi:2.11.2")
    compileOnly("io.lumine:Mythic-Dist:5.0.1-SNAPSHOT")
    compileOnly("io.papermc.paper:paper-api:1.18.2-R0.1-SNAPSHOT")
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.elmakers.mine.bukkit:EffectLib:9.4")
    shadow(kotlin("stdlib-jdk8"))

    implementation("com.elmakers.mine.bukkit:EffectLib:9.4")
    shadow("com.elmakers.mine.bukkit:EffectLib:9.4")

    implementation("com.ticxo.playeranimator:PlayerAnimator:R1.2.4")
    shadow("com.ticxo.playeranimator:PlayerAnimator:R1.2.4")
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}
tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveFileName.set("DivizionCore-${version}.jar")
    relocate("de.slikey", "ru.iamdvz.core.api.shaded.slikey")
    relocate("com.ticxo", "ru.iamdvz.core.api.shaded")
    //relocate("kotlin", "ru.iamdvz.core.shaded.kotlin")
    relocate("org.intellij", "ru.iamdvz.core.shaded.intellij")
    relocate("org.jetbrains", "ru.iamdvz.core.shaded.jetbrains")
    relocate("org.apache", "ru.iamdvz.core.shaded.apache")
}
tasks.processResources {
    filesMatching("plugin.yml") {
        expand(project.properties)
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}
