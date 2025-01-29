//5. Подсчет выходных за месяц
//Задача: Напишите метод, который принимает месяц и год
//и возвращает количество выходных (суббот и воскресений) в этом месяце.
import java.time.LocalDate
import java.time.YearMonth
import java.time.DayOfWeek

fun countWeekends(month: Int, year: Int): Int {
    val yearMonth = YearMonth.of(year, month)
    var weekendCount = 0

    for (day in 1..yearMonth.lengthOfMonth()) {
        val date = LocalDate.of(year, month, day)
        if (date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY) {
            weekendCount++
        }
    }
    return weekendCount
}

fun main() {
    val month = 1
    val year = 2024
    println("Выходных в $month/$year: ${countWeekends(month, year)}")
}