//1. Основы LocalDate и LocalTime
//Задача: Напишите программу, которая:
//Создает объект LocalDate, представляющий текущую дату.
//Создает объект LocalTime, представляющий текущее время.
//Выводит их значения в формате dd-MM-yyyy HH:mm:ss
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

fun main(){
    val date = LocalDate.now()
    val time = LocalTime.now()
    val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    println("Текущая дата и время: ${date.atTime(time).format(dateTimeFormatter)}")
}

