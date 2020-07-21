plugins {
    id("com.github.node-gradle.node") version "2.2.4"
}

val npmRunBuild = tasks.getByName("npm_run_build") {
    inputs.dir(file("src/main"))
    inputs.files(file("package.json"), file("webpack.config.js"))
    outputs.dir(file("dist/"))
    outputs.cacheIf { true }
}

task("generateFrontendFiles") {
    dependsOn(npmRunBuild)
}

tasks {
    clean {
        delete(file("node_modules"), file("dist"))
    }
}