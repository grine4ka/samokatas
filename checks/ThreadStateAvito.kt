package checks

import java.util.concurrent.locks.ReentrantLock

class State {
    @Volatile
    var x = 0
    @Volatile
    var y = 0
}

fun main() {
    val state = State()

    // using wait, notify
    val objY = Object()
    val objX = Object()

    val t1 = Thread {
        synchronized(objX) {
            state.x = 1
            objX.notifyAll()
        }
        synchronized(objY) {
            while (state.y == 0)
                objY.wait()
            println("y = ${state.y}")
        }
    }
    val t2 = Thread {
        synchronized(objY) {
            state.y = 1
            objY.notifyAll()
        }
        synchronized(objX) {
            while (state.x == 0)
                objX.wait()
            println("x = ${state.x}")
        }
    }

    // using lock
    val locker = ReentrantLock()
    val lockX = locker.newCondition()
    val lockY = locker.newCondition()
//    val t1 = Thread {
//        locker.lock()
//        try {
//            state.x = 1
//            lockX.signalAll()
//        } finally {
//            locker.unlock()
//        }
//        locker.lock()
//        try {
//            while (state.y == 0)
//                lockY.await()
//            println("y = ${state.y}")
//        } finally {
//            locker.unlock()
//        }
//    }
//    val t2 = Thread {
//        locker.lock()
//        try {
//            state.y = 1
//            lockY.signalAll()
//        } finally {
//            locker.unlock()
//        }
//        locker.lock()
//        try {
//            while (state.x == 0)
//                lockX.await()
//            println("x = ${state.x}")
//        } finally {
//            locker.unlock()
//        }
//    }

    t1.start()
    t2.start()

    t1.join()
    t2.join()
}