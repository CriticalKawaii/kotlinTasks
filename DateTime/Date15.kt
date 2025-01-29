//15. Определение дня недели по дате
//Задача: Напишите метод, который принимает дату
//и возвращает название дня недели на русском языке.
import java.time.LocalDate
import java.util.Locale
import java.time.format.DateTimeFormatter
fun getDayOfWeek(date: LocalDate): String{
    val formatter = DateTimeFormatter.ofPattern("EEEE", Locale("ru"))
    return date.format(formatter).replaceFirstChar { it.uppercaseChar() }
}
fun main() {
    val date = LocalDate.of(2025,1,30)
    println("день недели: ${getDayOfWeek(date)}")
}