//10. Создание календаря на месяц
//Задача: Напишите метод, который принимает месяц и год и выводит все даты
//месяца с указанием, является ли каждая из них рабочим днем или выходным.
import java.time.LocalDate
import java.time.YearMonth
import java.time.DayOfWeek

fun generateCalendar(month: Int, year: Int) {
    val yearMonth = YearMonth.of(year, month)
    println("Календарь на $month/$year:")

    for (day in 1..yearMonth.lengthOfMonth()) {
        val date = LocalDate.of(year, month, day)
        val dayType = if (date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY) {
            "Выходной"
        } else {
            "Рабочий день"
        }
        println("${date.dayOfMonth} (${date.dayOfWeek}): $dayType")
    }
}

fun main() {
    val month = 2
    val year = 2025
    generateCalendar(month, year)
}