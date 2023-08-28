package checks

import checks.ExtensionsCheck.Companion.companionExt

/**
 * Всегда ли extension функции компилируются в статические методы?
 */
fun main() {

    val extensionsCheck = ExtensionsCheck()

    println("Default value: " + extensionsCheck.extensionName)

    extensionsCheck.extensionName = ""
    println("Private inner class ext: " + extensionsCheck.someMethod())

    extensionsCheck.extensionName = ""
    println("Public inner class ext: " + extensionsCheck.someOtherMethod())

    extensionsCheck.extensionName = ""
    println("Companion ext: " + extensionsCheck.extensionName.companionExt())

    extensionsCheck.extensionName = ""
    println("Outer ext: " + extensionsCheck.extensionName.outerExt())
}

class ExtensionsCheck {

    private val privateProp = "Private Prop"
    var extensionName = ""

    fun someMethod(): String {
        return extensionName.privateInnerExt()
    }

    fun someOtherMethod(): String {
        return extensionName.publicInnerExt()
    }

    private fun String.privateInnerExt(): String {
        return this.plus("privateInnerExt").plus(privateProp)
    }

    fun String.publicInnerExt(): String {
        return this.plus("publicInnerExt").plus(privateProp)
    }

    companion object {
        fun String.companionExt(): String {
            return this.plus("companionExt")
        }
    }
}

fun String.outerExt(): String {
    return this.plus("outerExt")
}