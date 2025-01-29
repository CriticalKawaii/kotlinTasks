//11. Генерация случайной даты в диапазоне
//Задача: Реализуйте метод, который принимает две
//даты и генерирует случайную дату в этом диапазоне
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.random.Random

fun randomDate(date1: LocalDate, date2: LocalDate): LocalDate{
    val daysBetween = ChronoUnit.DAYS.between(date1, date2)
    return date1.plusDays(Random.nextLong(0, daysBetween + 1))
}
fun main() {
    val date1 = LocalDate.of(2000,1,1)
    val date2 = LocalDate.now()
    println("random date between $date1 and $date2 : ${randomDate(date1,date2)}")
}
