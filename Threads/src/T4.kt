//Задание 4: Программа с использованием Java NIO
//Задача: Напишите программу, которая копирует файл с использованием Java NIO.
//
//Использовать FileChannel для чтения и записи данных.
//Программа должна поддерживать возможность копирования больших файлов (> 1 Гб).
//Реализовать обработку исключений, связанных с доступом к файлу или его отсутствием.
//Условия:
//
//Используйте методы transferTo() или transferFrom() из FileChannel для копирования содержимого.
//Программа должна быть устойчива к прерыванию работы и сообщать об ошибках.
//Критерии:
//
//Корректная работа с большими файлами.
//Использование механизмов NIO и сравнение производительности с классическим IO (опционально).
//Пример:
//
//public static void copyFile(String source, String dest) throws IOException {
//    try (FileChannel srcChannel = new FileInputStream(source).getChannel();
//         FileChannel destChannel = new FileOutputStream(dest).getChannel()) {
//        srcChannel.transferTo(0, srcChannel.size(), destChannel);
//    }
//}
import java.io.*
import java.nio.channels.FileChannel

fun copyFileWithNIO(source: String, dest: String) {
    try {
        FileInputStream(source).channel.use { srcChannel ->
            FileOutputStream(dest).channel.use { destChannel ->
                var position = 0L
                val size = srcChannel.size()
                while (position < size) {
                    position += srcChannel.transferTo(position, size - position, destChannel)
                }
            }
        }
    } catch (e: FileNotFoundException) {
        println("File not found: ${e.message}")
    } catch (e: IOException) {
        println("IO error: ${e.message}")
    }
}

fun main() {
    copyFileWithNIO("source.txt", "dest.txt")
}