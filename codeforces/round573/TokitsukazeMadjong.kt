package round573

// https://codeforces.com/contest/1191/problem/B
fun main(args: Array<String>) {
    val listM = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    val listP = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    val listS = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    val input = readLine()!!.split(" ").map {
        Card(it[0].toString().toInt(), it[1].toString())
    }

    input.forEach {
        when(it.type) {
            "m" -> listM[it.number-1]++
            "p" -> listP[it.number-1]++
            "s" -> listS[it.number-1]++
        }
    }

    val koutsuM = listM.max()!!
    val shuntsuM = shuntsu(listM)

    if (koutsuM >= 3 || shuntsuM >= 3) {
        println("0")
        return
    }

    val koutsuP = listP.max()!!
    val shuntsuP = shuntsu(listP)
    if (koutsuP >= 3 || shuntsuP >= 3) {
        println("0")
        return
    }

    val koutsuS = listS.max()!!
    val shuntsuS = shuntsu(listS)
    if (koutsuS >= 3 || shuntsuS >= 3) {
        println("0")
        return
    }

    if (koutsuM >= 2 || shuntsuM >= 2 ||
            koutsuS >= 2 || shuntsuS >= 2 ||
            koutsuP >= 2 || shuntsuP >= 2) {
        println("1")
        return
    }

    println("2")
}

// return the number of subsequence > 0
fun shuntsu(list: Array<Int>): Int {
    val seq = ArrayList<Triple<Int, Int, Int>>()
    for (i in 0 until 7) {
        seq.add(Triple(list[i], list[i+1], list[i+2]))
    }
    var one = 0
    var two = 0
    for (triple in seq) {
        if (triple.first > 0 && triple.second > 0 && triple.third > 0) {
            return 3
        } else if (triple.first > 0 && triple.second > 0) {
            two++
        } else if (triple.first > 0 && triple.third > 0) {
            two++
        } else if (triple.second > 0 && triple.third > 0) {
            two++
        } else if (triple.first > 0 || triple.second > 0 || triple.third > 0) {
            one++
        }
    }
    if (two > 0) return 2
    if (one > 0) return 1
    return 0
}

class Card(val number: Int, val type: String)