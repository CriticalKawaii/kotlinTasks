//Задание 1: Работа с потоками ввода-вывода
//Задача: Напишите программу, которая читает текст из файла и записывает его в другой файл с изменениями:
//Программа должна читать содержимое исходного файла построчно.
//Преобразовать каждую строку текста в верхний регистр.
//Записать преобразованный текст в новый файл.
//Условия:
//Для работы с файлами использовать классы из пакета java.io: BufferedReader, BufferedWriter, FileReader, FileWriter.
//Программа должна быть устойчивой к ошибкам, например, если файл не найден.
//Использовать обработку исключений через try-with-resources.
import java.io.*

fun main() {
    try {
        BufferedReader(FileReader("input.txt")).use { reader ->
            BufferedWriter(FileWriter("output.txt")).use { writer ->
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    writer.write(line!!.uppercase())
                    writer.newLine()
                }
            }
        }
    } catch (e: FileNotFoundException) {
        println("File not found: ${e.message}")
    } catch (e: IOException) {
        println("IO error: ${e.message}")
    }
}
