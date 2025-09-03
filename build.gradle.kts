plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.yaremax"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val retrofitVersion = "2.11.0"
val moshiVersion = "1.15.2"
val coroutinesVersion = "1.8.1"

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")

    implementation("com.squareup.moshi:moshi:$moshiVersion")
    implementation("com.squareup.moshi:moshi-kotlin:$moshiVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}