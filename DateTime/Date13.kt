//13. Вычисление количества рабочих часов
//Задача: Напишите метод, который принимает два объекта LocalDateTime, представляющие
//начало и конец рабочего дня, и возвращает количество рабочих часов (без учета выходных)
import java.time.LocalDateTime
import java.time.DayOfWeek

fun countWorkHours(start: LocalDateTime, end: LocalDateTime): Long {
    var current = start
    var totalHours = 0L

    while (current.isBefore(end)){
        if(current.dayOfWeek != DayOfWeek.SATURDAY && current.dayOfWeek != DayOfWeek.SUNDAY){
            val nextHour = current.plusHours(1)
            if (nextHour.isAfter(end)) break
            totalHours++
        }
        current = current.plusHours(1)
    }
    return totalHours
}

fun main() {
    val start = LocalDateTime.of(2025, 1, 31, 12, 0)
    val end = LocalDateTime.of(2025, 2, 1, 18, 0)
    println("work hours from $start to $end : ${countWorkHours(start, end)}")
}