package kotlinheroes

// CodeForces https://codeforces.com/contest/1170/problem/B

import kotlin.math.min

fun main() {
    println("Enter number of days:")
    val days = readLine()!!.toInt()
    println("Enter number of visits divided by space:")
    val visitsString = readLine()!!
    val visits = visitsString.split(" ").take(days).map { it.toInt() }
    println("Number of unsuccessful days: ${findUnsuccessfulDays(visits)}")
    println(findUnsuccessfulDays(visits))
}

fun findUnsuccessfulDays(visits: List<Int>): Int {
    if (visits.size < 3)
        return 0
    var count = 0
    var max1 = visits[0]
    var max2 = visits[1]
    for (i in 2 until visits.size) {
        val visit = visits[i]
        if (visit < max1 && visit < max2) {
            count++
        }
        val minOfMax = min(max1, max2)
        if (visit > minOfMax) {
            if (minOfMax == max1)
                max1 = visit
            else
                max2 = visit
        }
    }
    return count
}
