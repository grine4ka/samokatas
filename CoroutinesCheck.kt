package ru.bykov

import kotlinx.coroutines.*
import kotlin.math.sqrt

fun main() {
    println("Start")

    // launch
    println("launch coroutine example")
    GlobalScope.launch {
        println("Inside launch")
        delay(1000)
        println("Hello")
    }
    println("After launch")

    runBlocking {
        delay(1000)
    }

    // async
    println("async coroutine example")
    val deferred = (1..1_000_000).map { n ->
        GlobalScope.async {
            delay(1000)
            n
        }
    }
    runBlocking {
        val sum = deferred.sumBy { it.await() }
        println("Sum: $sum")
    }

    // mine
    println("custom coroutine example")
    val root4 = getRoot(4)
    val root9 = getRoot(9)
    GlobalScope.launch {
        println("Inside launch")
        println("Wait for root of 4")
        val res2 = root4.await()
        println("Root of 4: $res2")
        println("Wait for root of 9")
        val res3 = root9.await()
        println("Root of 9: $res3")
        println("Sum: ${res2 + res3}")
    }
    println("After launch")

    runBlocking {
        delay(5000)
    }
    println("Stop")
}

fun getRoot(n: Int) = GlobalScope.async {
    delay(2000)
    sqrt(n.toDouble())
}
