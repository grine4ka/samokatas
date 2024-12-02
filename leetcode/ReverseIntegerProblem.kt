package leetcode

// https://leetcode.com/problems/reverse-integer/
fun main() {
    val i1 = 123
    println(reverse(i1))
    val i2 = -123
    println(reverse(i2))
    val i3 = 120
    println(reverse(i3))

    val max = Int.MAX_VALUE
    println(reverse(max))

    val min = Int.MIN_VALUE
    println(reverse(min))

    val palindrome = 2147447412
    println(reverse(palindrome))
}

fun reverse(x: Int): Int {
    // with string
//    return try {
//        abs(x).toString().reversed().toInt() * x.sign
//    } catch (ex: NumberFormatException) {
//        0
//    }
    // with arithmetic
    var rest = x
    var result = 0
    while (rest != 0) {
        if (result > Int.MAX_VALUE / 10 || result < Int.MIN_VALUE / 10) return 0
        result = result * 10 + rest % 10
        rest /= 10
    }
    return result
}