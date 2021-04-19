package ru.bykov.codeforces.tinkoffcup1

import java.io.PrintWriter

/**
 * Юля, Вася и Лена играют в игру.
 * Сначала Юля выписывает на карточки несколько чисел 𝑎1,𝑎2,…,𝑎𝑘, при этом все числа должны делиться на 4.
 * После чего Вася делает еще 𝑘 карточек, на которых пишет числа 3𝑎1/4,3𝑎2/4,…,3𝑎𝑘/4 и перемешивает получившиеся 𝑛=2𝑘 карточек.
 *
 * После чего карточки отдаются Лене, и она должна понять, какие из них были сделаны Васей. Помогите Лене.
 *
 * Входные данные
 * В первой строке входных данных находится одно целое четное число 𝑛 (2≤𝑛≤105) — количество карточек, которые отдали Лене.
 * Следующие 𝑛 строк содержат числа, написаннные на карточках, в порядке неубывания.
 * Каждое из этих чисел целое, положительное, четное, а также не превосходит 10^9.
 *
 * Выходные данные
 * Необходимо вывести 𝑘=𝑛/2 чисел в порядке неубывания, которые написаны на карточках, сделанных Васей.
 */
fun main() {
    bufferOut {
        solveProblem()
    }
}

private fun PrintWriter.solveProblem() {
    val n = readInt()
    val cards = IntArray(n) {
        readInt()
    }

    val isYuliasCard = BooleanArray (n) { false }
    for (i in 0 until n) {
        val card = cards[i]
        if (isYuliasCard[i]) continue
        cards.findOriginCardFor(isYuliasCard, card)
    }
    for (i in 0 until n) {
        if (isYuliasCard[i]) continue
        println(cards[i])
    }
}

private fun IntArray.findOriginCardFor(isYuliasCard: BooleanArray, card: Int) {
    val candidate = card / 3 * 4
    var ind = binarySearch(candidate)
    if (ind >= 0) {
        isYuliasCard[ind] = true
    }
}

private fun readInt() = readLine()!!.toInt()

private fun bufferOut(block: PrintWriter.() -> Unit) = PrintWriter(System.out).use { block(it) }