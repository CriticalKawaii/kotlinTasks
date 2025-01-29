//4. Проверка високосного года
//Задача: Реализуйте метод, который принимает год и возвращает true,
//если он является високосным, и false в противном случае.
import java.time.Year
fun isLeapYear(year: Year): Boolean{
    return (year.toString().toInt() % 4 == 0 && year.toString().toInt() % 100 != 0) || (year.toString().toInt() % 400 == 0)
}

fun main() {
    print("enter a year: ")
    val year = Year.of(readln().toInt())
    println("Is $year a leap year: ${isLeapYear(year)}")
}