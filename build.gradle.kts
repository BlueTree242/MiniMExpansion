plugins {
    id("java")
    id("net.kyori.blossom") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

version = "1.1.1"

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
    val prefix = "dev.bluetree242.minim.dependencies"
    relocate("net.kyori.adventure", "$prefix.adventure")
    relocate("net.kyori.examination", "$prefix.examination")
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    tCompileOnly("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT")
    tCompileOnly("me.clip:placeholderapi:2.11.5")
    tImplementation("net.kyori:adventure-api:4.15.0")
    tImplementation("net.kyori:adventure-text-minimessage:4.15.0")

    testImplementation("org.mockito:mockito-core:3.12.4")
    testImplementation("org.mockito:mockito-inline:3.12.4")
    testImplementation("org.mockito:mockito-junit-jupiter:5.3.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

fun DependencyHandlerScope.tCompileOnly(dep: String) {
    compileOnly(dep)
    testImplementation(dep)
}

fun DependencyHandlerScope.tImplementation(dep: String) {
    implementation(dep)
    testImplementation(dep)
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


