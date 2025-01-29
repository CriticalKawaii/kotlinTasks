//3. Сколько дней до Нового года?
//Задача: Создайте метод, который определяет количество дней до Нового года от текущей даты.
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun daysTilNewYear(date: LocalDate): Long{
    val newYearDate = LocalDate.of(date.year + 1, 1, 1)
    return ChronoUnit.DAYS.between(date, newYearDate)
}

fun main() {
    val date = LocalDate.now()
    println("days until new yer: ${daysTilNewYear(date)}")
}