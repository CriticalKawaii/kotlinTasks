//Задание 3: Сравнение производительности IO и NIO
//Задача: Напишите программу, которая читает большой текстовый файл (например, несколько мегабайт) двумя способами:
//С использованием стандартных классов IO (FileReader и BufferedReader).
//С использованием NIO (классы FileChannel, ByteBuffer, Files).
//Условия:
//Измерьте время выполнения каждой операции (чтение и запись файла).
//Выведите результаты на консоль для сравнения производительности.
//Критерии:
//Программа должна читать файл целиком и записывать его в другой файл.
//Время выполнения каждого метода должно быть замерено с помощью System.currentTimeMillis() или System.nanoTime().
//Сделайте выводы на основе полученных данных: какой метод быстрее для больших файлов и почему.
//Пример кода для замера времени:
//long startTime = System.currentTimeMillis();
//// Чтение или запись файла
//long endTime = System.currentTimeMillis();
//System.out.println("Время выполнения: " + (endTime - startTime) + " ms");
import java.io.*
import java.nio.ByteBuffer
import kotlin.system.measureTimeMillis

fun readWithIO(source: String, target: String) {
    BufferedReader(FileReader(source)).use { reader ->
        BufferedWriter(FileWriter(target)).use { writer ->
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                writer.write(line)
                writer.newLine()
            }
        }
    }
}

fun readWithNIO(source: String, target: String) {
    FileInputStream(source).channel.use { srcChannel ->
        FileOutputStream(target).channel.use { destChannel ->
            val buffer = ByteBuffer.allocate(1024 * 1024)
            while (srcChannel.read(buffer) > 0) {
                buffer.flip()
                destChannel.write(buffer)
                buffer.clear()
            }
        }
    }
}

fun main() {
    val source = "large_file.txt"
    val targetIO = "output_io.txt"
    val targetNIO = "output_nio.txt"

    val timeIO = measureTimeMillis { readWithIO(source, targetIO) }
    println("IO time: $timeIO ms")

    val timeNIO = measureTimeMillis { readWithNIO(source, targetNIO) }
    println("NIO time: $timeNIO ms")
}