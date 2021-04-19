package ru.bykov.codeforces.tinkoffcup1

import java.io.PrintWriter

/**
 * Иван опаздывает на работу! Ехать ему предстоит на одном из трех видов транспорта: автобус, электробус или электричка.
 * У них у всех разный интервал движения, а также разная скорость.
 * Работа Ивана находится на следующей остановке, однако дойти до туда пешком не получится.
 * Известно, что автобус будет ехать от дома до работы Ивана A минут, электробус — B минут, а электричка доедет за C минут.
 * Также известно, что автобус ходит с интервалом в 15 минут, электробус — 10 минут, а электричка — 5 минут.
 * При этом известно, что в 8:00 все виды транспорта приезжают на остановку у дома Ивана одновременно.
 *
 * Ваня пришел на остановку и увидел, что на часах уже 8 часов и D минут!
 * Вам необходимо помочь Ване понять, через какое минимальное время он может оказаться на работе.
 *
 * Входные данные
 * В первых трех строках входных данных даны три целых числа 𝐴, 𝐵, 𝐶 (1≤𝐴,𝐵,𝐶≤100) — время поездки на автобусе, электробусе и электричке соответственно.
 * В четвертой строке входных данных записано целое число 𝐷 (0≤𝐷≤59) — число минут на часах, когда Ваня пришел на остановку.
 *
 * Выходные данные
 * Необходимо вывести одно число — минимальное время, через которое Ваня сможет оказаться на работе.
 */
fun main() {
    bufferOut {
        solveProblem()
    }
}

private fun PrintWriter.solveProblem() {
    val timeBus = readIntFromLine()
    val timeEBus = readIntFromLine()
    val timeElectro = readIntFromLine()
    val minutes = readIntFromLine()

    val tempBus = minutes % 15
    val timeToBus = if (tempBus == 0) 0 else 15 - tempBus

    val tempEBus = minutes % 10
    val timeToEBus = if (tempEBus == 0) 0 else 10 - tempEBus

    val tempElectro = minutes % 5
    val timeToElectro = if (tempElectro == 0) 0 else 5 - tempElectro

    val timeWorkBus = timeToBus + timeBus
    val timeWorkEBus = timeToEBus + timeEBus
    val timeWorkElectro = timeToElectro + timeElectro

    val min = minOf(timeWorkBus, timeWorkEBus, timeWorkElectro)

    println(min)
}

private fun readIntFromLine() = readLine()!!.toInt()

private fun bufferOut(block: PrintWriter.() -> Unit) = PrintWriter(System.out).use { block(it) }