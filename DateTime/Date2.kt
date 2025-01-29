//2. Сравнение дат
//Задача: Напишите метод, который принимает две даты (LocalDate)
//и определяет, какая из них больше, меньше или равна другой. Верните соответствующее сообщение.
import java.time.LocalDate
fun compareDates(date1: LocalDate, date2: LocalDate): String{
    return when{
        date1.isAfter(date2) -> "$date1 is bigger than $date2"
        date1.isBefore(date2) -> "$date1 is lesser than $date2"
        else -> "$date1 is equal to $date2"
    }
}
fun main() {
    print("1st date:\n\tyear: ")
    var year = readln().toInt()
    print("\tmonth: ")
    var month = readln().toInt()
    print("\tday: ")
    var day = readln().toInt()
    val date = LocalDate.of(year, month, day)

    print("2nd date:\n\tyear: ")
    year = readln().toInt()
    print("\tmonth: ")
    month = readln().toInt()
    print("\tday: ")
    day = readln().toInt()

    println(compareDates(date,LocalDate.of(year, month, day)))
}