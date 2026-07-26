plugins {
    application
}

group = "com.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.4")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

application {
    mainClass.set("com.practice.Main")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
