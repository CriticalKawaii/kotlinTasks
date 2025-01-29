//9. Вычисление возраста по дате рождения
//Задача: Напишите метод, который принимает дату рождения
//в формате LocalDate и возвращает текущий возраст в годах
import java.time.LocalDate
import java.time.Period

fun getAge(dateOfBirth: LocalDate): Int {
    return Period.between(dateOfBirth,LocalDate.now()).years
}

fun main() {
    val birthDate = LocalDate.of(1995, 6, 15)
    println("Возраст: ${getAge(birthDate)} лет")
}