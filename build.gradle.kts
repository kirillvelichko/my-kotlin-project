import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    id("org.springframework.boot") version "2.2.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.4.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.61")
    implementation("io.github.openfeign:feign-soap:10.7.4")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.3.61")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.2")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:2.2.1.RELEASE")
    implementation("io.github.openfeign:feign-httpclient:10.7.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test:2.2.4.RELEASE")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            //freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}