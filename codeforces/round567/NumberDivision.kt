package round567

import java.lang.Math.max

// TODO not solved
// https://codeforces.com/contest/1181/problem/B
fun main(args: Array<String>) {
    val l = readLine()!!
    val n = readLine()!!

    // 1234000056 = round567.min(123 + 4000056, 12340000 + 56)
    println(min(l, n))
}

fun sumStrings(s1: String, s2: String): String {
    var carry = 0
    val s1size = s1.length
    val s2size = s2.length
    val size = max(s1size, s2size)
    val result = StringBuilder()
    val s1r = s1.reversed()
    val s2r = s2.reversed()
    for (i in 0 until size) {
        val x = if (i < s1size) Character.getNumericValue(s1r[i]) else 0
        val y = if (i < s2size) Character.getNumericValue(s2r[i]) else 0
        var sumI = carry + x + y
        carry = sumI / 10
        sumI %= 10
        result.append(sumI)
    }
    if (carry > 0) result.append(carry)

    return result.reverse().toString()
}

fun min(s1: String, s2: String): String {
    if (s1.length < s2.length) return s1
    if (s2.length < s1.length) return s2
    for (i in 0 until s1.length) {
        val n1 = Character.getNumericValue(s1[i])
        val n2 = Character.getNumericValue(s2[i])
        if (n1 < n2) return s1
        if (n2 < n1) return s2
    }
    return s1
}