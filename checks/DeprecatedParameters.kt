package checks

import kotlin.collections.ArrayList

/**
 * Дан список параметров некоторой функции.
 * Некоторые параметры помечены как deprecated.
 * Необходимо сгенерировать методы с параметрами, чтобы сохранить обратную совместимость
 */
fun main() {
    val parameters = linkedMapOf(
        "a" to true,
        "b" to false,
        "c" to true,
        "d" to false,
    )

    val notDeprecatedPositions = mutableListOf<Int>()
    parameters.toList().forEachIndexed { index, (_, deprecated) ->
        if (deprecated.not()) {
            notDeprecatedPositions.add(index)
        }
    }

    printAllSubsets(parameters.toList(), notDeprecatedPositions)
        .also { println("Size of sets is ${it.size}") }
        .forEach {
            println(it.toString())
        }

}

fun printAllSubsets(list: List<Pair<String, Boolean>>, notDeprecatedParameterPositions: List<Int>): List<List<String>> {
    val subsets: MutableList<List<String>> = ArrayList()
    val size = list.size
    for (mask in 0 until (1 shl size)) {
        val hasOneBitAtPositions = mask.hasOneBitAtPositions(notDeprecatedParameterPositions)
        if (hasOneBitAtPositions.not()) {
            continue
        }
        println(Integer.toBinaryString(mask).padStart(size, '0'))
        println("Mask has one bits at positions $notDeprecatedParameterPositions")
        val subset: MutableList<String> = ArrayList()
        for (j in list.indices) {
            if (mask and (1 shl j) != 0) {
                subset.add(list[j].first)
            }
        }
        subsets.add(subset)
    }
    return subsets
}

private fun Int.hasOneBitAtPositions(oneBitPositions: List<Int>): Boolean {
    return oneBitPositions.all { hasOneBitAtPosition(it) }
}

private fun Int.hasOneBitAtPosition(position: Int): Boolean {
    return ((this shr position) and 1) == 1
}
