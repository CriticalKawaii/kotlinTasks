//12. Расчет времени до заданной даты
//Задача: Создайте метод, который принимает дату и время события и рассчитывает,
//сколько часов, минут и секунд осталось до него от текущего момента.
import java.time.LocalDateTime
import java.time.Duration

fun hhmmssTilNewYear(date: LocalDateTime): Any {
    val now = LocalDateTime.now()
    if (now.isAfter(date)) return "event already happened!"

    val duration = Duration.between(now, date)

    val hours = duration.toHours()
    val minutes = duration.toMinutes() % 60
    val seconds = duration.seconds % 60

    return "time until event: $hours hours, $minutes minutes, $seconds seconds"
}

fun main() {
    val date = LocalDateTime.of(2025, 1, 31, 0, 0, 0)
    println("days until event: ${hhmmssTilNewYear(date)}")
}