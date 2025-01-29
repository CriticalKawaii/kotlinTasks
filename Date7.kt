//7. Форматирование и парсинг даты
//Задача: Напишите программу, которая принимает строку даты в формате dd-MM-yyyy,
//конвертирует ее в объект LocalDate, добавляет к ней 10 дней и выводит результат в формате yyyy/MM/dd
import java.time.LocalDate
import java.time.format.DateTimeFormatter
fun strToLocalDateAdd10Days(str: String): String{
    var date = LocalDate.parse(str,DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    date = date.plusDays(10)
    return date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
}
fun main() {
    print("enter a string in dd-MM-yyyy format: ")
    val str = readln()
    println(strToLocalDateAdd10Days(str))
}