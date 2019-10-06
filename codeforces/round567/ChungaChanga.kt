package round567

import kotlin.math.max
import kotlin.math.min

// https://codeforces.com/contest/1181/problem/A
fun main(args: Array<String>) {
    val input = readLine()!!.split(" ").map(String::toInt)
    val x = input[0]
    val y = input[1]
    val price = input[2]

    println("First has $x money, second has $y money; Coconut has price $price")
    val one = x / price
    println("First bought $one nuts")
    val two = y / price
    println("Second bought $two nuts")

    val remain1 = x % price
    println("First has $remain1 money after buy")
    val remain2 = y % price
    println("Second has $remain2 money after buy")

    val oneMore = price - max(remain1, remain2)
    if (min(remain1, remain2) >= oneMore) {
        println("${one+two+1} $oneMore")
    } else {
        println("${one+two} 0")
    }
}