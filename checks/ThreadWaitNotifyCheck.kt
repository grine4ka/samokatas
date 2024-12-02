package checks

class Message(var msg: String)

class Waiter(private val msg: Message) : Runnable {
    override fun run() {
        val name = Thread.currentThread().name
        synchronized(msg) {
            try {
                println(name + " waiting to get notified at time:" + System.currentTimeMillis())
                (msg as Object).wait()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            println(name + " waiter thread got notified at time:" + System.currentTimeMillis())
            //process the message now
            println(name + " processed: " + msg.msg)
        }
    }
}

class Notifier(private val msg: Message) : Runnable {
    override fun run() {
        val name = Thread.currentThread().name
        println("$name started")
        try {
            Thread.sleep(1000)
            synchronized(msg) {
                msg.msg = "$name Notifier work done"
                (msg as Object).notifyAll()
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}

fun main() {
    val msg = Message("process it")
    val waiter = Waiter(msg)
    Thread(waiter, "waiter").start()

    val waiter1 = Waiter(msg)
    Thread(waiter1, "waiter1").start()

    val notifier = Notifier(msg)
    Thread(notifier, "notifier").start()
    println("All the threads are started")
}