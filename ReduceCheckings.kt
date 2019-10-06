package ru.bykov

import rx.Observable

fun main(args: Array<String>) {

    val reducer: (String, String) -> String = { accumulator, new ->
        println("Reducing $new to $accumulator")
        accumulator + new
    }
    observable().reduce("Zero", reducer)
        .subscribe {
            println("Receiving $it")
        }
}

private fun observable(): Observable<String> {
    return Observable.just("One")
}