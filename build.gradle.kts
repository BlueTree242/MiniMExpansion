plugins {
    id("java")
    id("net.kyori.blossom") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

version = "1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    disableAutoTargetJvm()
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.build {
    finalizedBy(tasks.shadowJar)
}

tasks.shadowJar {
    archiveClassifier.set("")
    val prefix = "dev.bluetree242.papiminicolors.dependencies"
    relocate("net.kyori.adventure", "$prefix.adventure")
    relocate("net.kyori.examination", "$prefix.examination")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.5")
    implementation("net.kyori:adventure-api:4.15.0")
    implementation("net.kyori:adventure-text-minimessage:4.15.0")

    testImplementation("me.clip:placeholderapi:2.11.5")
    testImplementation("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT")
    testImplementation("net.kyori:adventure-api:4.15.0")
    testImplementation("net.kyori:adventure-text-minimessage:4.15.0")

    testImplementation("org.mockito:mockito-core:3.12.4")
    testImplementation("org.mockito:mockito-inline:3.12.4")
    testImplementation("org.mockito:mockito-junit-jupiter:5.3.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

sourceSets {
    main {
        blossom {
            javaSources {
                property("version", project.version.toString())
            }
        }
    }
}

tasks.test {
    useJUnitPlatform()
}


