package stepik.sportprogramming

import java.io.File

fun main() {
    val applications = mutableListOf<Application>()
    File("stepik/sportprogramming/request2.in").forEachLine {
        applications.add(readApplication(it))
    }
    println("Max of applications is ${count(applications)}")
}

private fun count(applications: List<Application>): Int {
    val sortedApps = applications.sortedBy { it.right }

    var cnt = 1
    var last = 0
    for (i in 1 until sortedApps.size) {
        val app = sortedApps[i]
        if (app.left >= sortedApps[last].right) {
            cnt++
            last = i
        }
    }
    return cnt
}

private class Application(val left: Int, val right: Int)

private fun readApplication(string: String): Application {
    val ints = string.split(" ").map { it.toInt() }.toIntArray()
    return Application(ints[0], ints[1])
}
