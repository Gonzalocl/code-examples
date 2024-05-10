import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
    id("app.cash.sqldelight") version "2.0.1"
}

group = "org.eu.gonzalocaparros"
version = "1.0"

//java {
//    sourceCompatibility = JavaVersion.VERSION_17
//    targetCompatibility = JavaVersion.VERSION_17
//}

repositories {
    google()
    mavenCentral()
}

dependencies {
//    implementation("app.cash.sqldelight:jdbc-driver:2.0.1")
    implementation("app.cash.sqldelight:sqlite-driver:2.0.1")
    testImplementation(kotlin("test"))
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

//sqldelight {
//    databases {
//        create("Database") {
//            packageName.set("com.example")
//            dialect("app.cash.sqldelight:postgresql-dialect:2.0.1")
//        }
//    }
//}


sqldelight {
    databases {
        create("Database") {
            packageName.set("com.example")
        }
    }
}
