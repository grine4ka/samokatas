package stepik.sportprogramming

fun main() {
    val (n, routeDistance, petrolDistance) = readTriple()
    val stops = readLongs().toMutableList().apply { add(routeDistance) }

    var way = petrolDistance
    var cnt = 0
    for (i in 0 until n) {
        if (stops[i + 1] > way) {
            way = stops[i] + petrolDistance
            println("Stop number $cnt at ${stops[i]}")
            cnt++
        }
    }
    println("Min amount of stops is $cnt")
}

private fun readTriple(): Triple<Int, Long, Long> {
    val conditions = readLine()!!.split(" ").map(String::toLong).toLongArray()
    return Triple(conditions[0].toInt(), conditions[1], conditions[2])
}

private fun readLongs() = readLine()!!.split(" ").map(String::toLong).toLongArray()
