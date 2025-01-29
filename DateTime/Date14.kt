//14. Конвертация даты в строку с учетом локали
//Задача: Создайте метод, который принимает объект LocalDate и
//выводит его в строковом формате с учетом локали, например, ru или en.
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun formatDateWithLocale(date: LocalDate, locale: Locale): String{
    return date.format(DateTimeFormatter.ofPattern("d MMMM yyyy", locale))
}
fun main() {
    val date = LocalDate.of(2025, 2, 15)
    println("RU: " + formatDateWithLocale(date, Locale("ru")))
    println("EN: " + formatDateWithLocale(date, Locale.ENGLISH))
}