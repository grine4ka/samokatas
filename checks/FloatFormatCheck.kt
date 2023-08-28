package checks

import java.util.*

fun main(args: Array<String>) {

    val s = "{" +
            "\"1\" : %1$.2f,\n" +
            "\"2\" : %2$.2f,\n" +
            "\"3\" : 0,\n" +
            "\"4\" : 0\n" +
            "}"

    println(s.format(Locale.US, 0.02F, -0.01F))

    val sb = "Boolean format %b"
    println(sb.format(true))
}