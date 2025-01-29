//8. Конвертация между часовыми поясами
//Задача: Напишите метод, который принимает дату и время в часовом поясе
//UTC и конвертирует его в другой часовой пояс, например, Europe/Moscow
import java.time.*
import java.time.format.DateTimeFormatter
fun convertTimeZone(utcDateTime: String, targetZone: String): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    val utcZonedDateTime = LocalDateTime.parse(utcDateTime, formatter)
        .atZone(ZoneId.of("UTC"))

    return utcZonedDateTime
        .withZoneSameInstant(ZoneId.of(targetZone))
        .format(formatter)
}
fun main() {
    val utcDateTime = "2025-01-29 12:00:00"
    val targetZone = "Europe/Moscow"
    val convertedTime = convertTimeZone(utcDateTime, targetZone)
    println("Конвертированное время: $convertedTime")
}