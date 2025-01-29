//Задание 5: Асинхронное чтение файла с использованием NIO.2
//Задача: Напишите программу, которая выполняет асинхронное чтение файла с использованием NIO.2.
//
//Используйте классы AsynchronousFileChannel и CompletionHandler.
//Программа должна читать файл и выводить его содержимое на консоль по мере чтения.
//Условия:
//
//Файл должен считываться асинхронно в отдельном потоке.
//Реализуйте CompletionHandler для обработки завершения чтения файла и ошибок.
//Критерии:
//
//Правильная работа с асинхронным API.
//Асинхронная обработка завершения операции чтения.
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.channels.CompletionHandler
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import java.util.concurrent.CountDownLatch

fun main() {
    val path = Paths.get("input.txt")
    val channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)
    val latch = CountDownLatch(1)

    val buffer = ByteBuffer.allocate(1024)
    channel.read(buffer, 0, Unit, object : CompletionHandler<Int, Unit> {
        override fun completed(result: Int, attachment: Unit) {
            if (result != -1) {
                buffer.flip()
                val bytes = ByteArray(buffer.remaining())
                buffer.get(bytes)
                println(String(bytes))
                buffer.clear()
                latch.countDown()
            }
            channel.close()
        }

        override fun failed(exc: Throwable, attachment: Unit) {
            println("Error: ${exc.message}")
            latch.countDown()
            channel.close()
        }
    })

    latch.await()
}