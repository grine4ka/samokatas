package stepik.sportprogramming

import java.io.File

fun main() {
    val rooms = IntArray(33000) { 0 }
    val applications = readFromFile()
    println("Max of applications is ${count(rooms, applications)}")
}

private fun readFromFile(): MutableList<AudienceApplication> {
    val applications = mutableListOf<AudienceApplication>()
    File("stepik/sportprogramming/request2unlim.in").forEachLine {
        applications.add(readApplication(it))
    }
    return applications
}

private fun readFromInput(): MutableList<AudienceApplication> {
    val applications = mutableListOf<AudienceApplication>()
    val n = readInt()
    repeat(n) {
        applications.add(readApplication(readLine()!!))
    }
    return applications
}

private fun count(rooms: IntArray, applications: List<AudienceApplication>): Int {
    for (application in applications) {
        for (i in application.left until application.right) {
            rooms[i]++
        }
    }
    return rooms.max()!!
}

private class AudienceApplication(val left: Int, val right: Int)

private fun readInt() = readLine()!!.trim().toInt()

private fun readApplication(string: String): AudienceApplication {
    val ints = string.split(" ").map { it.trim().toInt() }.toIntArray()
    return AudienceApplication(ints[0], ints[1])
}

private fun readInts() = readLine()!!.split(" ").map(String::toInt).toIntArray()
