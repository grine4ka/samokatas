// CodeForces https://codeforces.com/contest/1170/problem/A
fun main() {
    val sums = mutableListOf<Pair<Int, Int>>()
    println("Enter number of requests:")
    val requests = readLine()!!.toInt()
    println("Enter sums of nums:")
    for (i in 0 until requests) {
        val (a, b) = readLine()!!.split(" ")
        sums.add(a.toInt() to b.toInt())
    }
    sums.map { (sumAB, sumBC) -> findNums(sumAB, sumBC) }
        .forEach {
            println("${it.first} ${it.second} ${it.third}")
        }
}

fun findNums(sumAB: Int, sumBC: Int): Triple<Int, Int, Int> {
    return if (sumAB > sumBC) {
        val a = sumAB - sumBC + 1
        val b = sumBC - 1
        val c = sumBC - sumBC + 1
        Triple(a, b, c)
    } else {
        val a = sumAB - sumAB + 1
        val b = sumAB - 1
        val c = sumBC - sumAB + 1
        Triple(a, b, c)
    }
}