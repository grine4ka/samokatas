package ru.bykov.checks

import rx.Completable
import rx.schedulers.Schedulers
import java.util.concurrent.ThreadLocalRandom

fun main(args: Array<String>) {
//    val first = AtomicBoolean(true)
//    Observable.defer {
//        Observable.just(1)
//    }
//            .flatMap {
//                Observable.fromCallable { ru.bykov.intenseCalculation(it.toString()) }
//                        .observeOn(Schedulers.newThread())
//                        .startWith("zero")
//                        .doOnNext {
//                            if (first.getAndSet(false)) {
//                                println("Starting with on " + Thread.currentThread().name)
//                            }
//                        }
//            }
//            .subscribe {
//                println("Receiving $it on " + Thread.currentThread().name)
//            }

    val completableFirst = Completable.fromAction { intenseCalculation("first") }

    val completableSecond = Completable
        .fromAction { intenseCalculation("second") }
        .subscribeOn(Schedulers.newThread())

    val completableThird = Completable.defer {
        Completable
            .fromAction { intenseCalculation("third") }
//                .subscribeOn(Schedulers.newThread())
    }

    Completable.concat(completableFirst, completableSecond, completableThird)
        .subscribeOn(Schedulers.io())
        .subscribe {
            println("Receiving on " + Thread.currentThread().name)
        }

    Thread.sleep(20000)
}

private fun intenseCalculation(string: String): String {
    println("Calculating $string on " + Thread.currentThread().name)
    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000).toLong())
    return string
}