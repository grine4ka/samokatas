package checks.classpaths.app

import lib.Library

fun main(args: Array<String>) {
    val lib = Library()

    val arg = args.firstOrNull() ?: "truth"
    lib.javaClass
        .getDeclaredMethod(arg)
        .invoke(lib)
}
