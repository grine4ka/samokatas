package stepik.sportprogramming

import java.io.PrintWriter
import java.math.BigInteger
import java.util.*

fun main() {
    output {
        val n = readInt()
        val m = readInt()
        val r = readInt()

//      Решение с http://www.e-maxx-ru.1gb.ru/algo/profile_dynamics
        val d = Array(n + 1) {
            Array(1 shl m) { BigInteger.ZERO }
        }
        d[0][0] = BigInteger.ONE
        for (i in 0 until n) {
            for (mask in 0 until (1 shl m)) {
                calc(i, 0, mask, 0, d, n, m)
            }
        }
        val remainder = d[n][0].remainder(BigInteger.valueOf(r.toLong()))
        println("Solution is ${remainder}")

//      Решение из лекции
//        val a = Array(m + 1) {
//            Array<BigInteger>(1 shl n) { BigInteger.ZERO }
//        }
//        a[0][0] = BigInteger.ONE
//        for (i in 0 until m) {
//            for (mask in 0 until (1 shl n)) {
//                for (newMask in 0 until (1 shl n)) {
//                    if (can(mask, newMask, n)) {
//                        a[i + 1][newMask] = a[i + 1][newMask].add(a[i][mask])
//                    }
//                }
//            }
//        }
//        val remainder = a[m][0].remainder(BigInteger.valueOf(r.toLong()))
//        println("Solution is ${remainder}")

//      Решение с https://neerc.ifmo.ru/wiki/index.php?title=Динамическое_программирование_по_профилю
//        val d = Array(1 shl n) {
//            Array<BigInteger>(1 shl n) { BigInteger.ZERO }
//        }
//
//        for (i in 0 until (1 shl n)) {
//            for (j in 0 until (1 shl n)) {
//                if (can(i, j, n)) {
//                    d[i][j] = BigInteger.ONE
//                }
//            }
//        }
//        println(d.joinToString("\n") { it.joinToString() })
//        println()

//        val a = Array(m) {
//            Array<BigInteger>(1 shl n) { BigInteger.ZERO }
//        }
//        a[0][0] = BigInteger.ONE
//        for (k in 1 until m) {
//            for (mask in 0 until (1 shl n)) {
//                for (newMask in 0 until (1 shl n)) {
//                    if (d[newMask][mask] != BigInteger.ZERO) {
//                        a[k][mask] = a[k][mask].add(a[k - 1][newMask])
//                    }
//                }
//            }
//        }
//        var ans = BigInteger.ZERO
//        for (i in 0 until (1 shl n)) {
//            if (canBeFinished(i, n)) {
//                ans = ans.add(a[m - 1][i])
//            }
//        }
//        val remainder = ans.remainder(BigInteger.valueOf(r.toLong()))
//        println("Solution is $remainder")
    }
}

private fun calc(i: Int = 0, j: Int = 0, mask: Int = 0, nextMask: Int = 0, d: Array<Array<BigInteger>>, n: Int, m: Int) {
    if (i == n) {
        return
    }
    if (j >= m) {
        d[i + 1][nextMask] = d[i + 1][nextMask].add(d[i][mask])
    } else {
        val jbit = 1 shl j
        if ((mask and jbit) != 0) {
            calc(i, j + 1, mask, nextMask, d, n, m)
        } else {
            calc(i, j + 1, mask, nextMask or jbit, d, n, m)
            if (j + 1 < m && (mask and jbit) == 0 && (mask and (jbit shl 1)) == 0)
                calc(i, j + 2, mask, nextMask, d, n, m)
        }
    }
}

private fun canBeFinished(mask: Int, n: Int): Boolean {
    var i = 0
    while (i < n) {
        val ibit = mask and (1 shl i)
        if (ibit == 0) {
            i++
            if (i >= n) return false

            val nextbit = mask and (1 shl i)
            if (nextbit != 0) return false
        }
        i++
    }
    return true
}

private fun can(mask: Int, newMask: Int, n: Int): Boolean {
    if ((mask and newMask) != 0) return false
    val tempMask = mask or newMask // проверить что нули идут парами в этой маске
    var i = 0
    while (i < n) {
        val ibit = tempMask and (1 shl i)
        if (ibit == 0) {
            i++
            if (i >= n) return false

            val nextbit = tempMask and (1 shl i)
            if (nextbit != 0) return false
        }
        i++
    }
    return true
}

/** IO code start */
private val INPUT = System.`in`
private val OUTPUT = System.out

private val reader = INPUT.bufferedReader()
private var tokenizer: StringTokenizer = StringTokenizer("")
private fun read(): String {
    if (tokenizer.hasMoreTokens().not()) {
        tokenizer = StringTokenizer(reader.readLine() ?: return "", " ")
    }
    return tokenizer.nextToken()
}

private fun readInt() = read().toInt()
private fun readIntArray(n: Int) = IntArray(n) { read().toInt() }

private val writer = PrintWriter(OUTPUT, false)
private inline fun output(block: PrintWriter.() -> Unit) {
    writer.apply(block).flush()
}
