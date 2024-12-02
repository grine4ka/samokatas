package checks

import java.io.File
import java.nio.file.FileSystems

fun main() {

    val modifiedFiles = listOf(
        "app/src/androidTest/assets/mocks/fintech/wbinstallments/flow33324/cwbConfig.json",
        "app/src/main/java/ru/wildberries/router/ProductCardScreens.kt",
        "build.gradle.kts",
        "ci/danger/Dangerfile.df.kts"
    ).map { File(it) }

    val excludedFilePatterns = listOf(
        "**/androidTest/**",
        "**/test/**",
        "**/build/**",
        "**/generated/**",
        "**/di/**"
    )
        .map {
            FileSystems.getDefault().getPathMatcher("glob:$it")
        }

    val includedFilePatterns = File("checks/coverage-report-included-files.txt")
        .readLines()
        .filter { !it.startsWith("#") && it.isNotBlank() }
        .map { FileSystems.getDefault().getPathMatcher("glob:$it") }

    val filteredTouchedFiles = modifiedFiles
        .filter { file ->
            excludedFilePatterns.none { it.matches(file.toPath()) }
                    && (includedFilePatterns.isEmpty() || includedFilePatterns.any { it.matches(file.toPath()) })
        }
    println("Filtered touched files: $filteredTouchedFiles")
}