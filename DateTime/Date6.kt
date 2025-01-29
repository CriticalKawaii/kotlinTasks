//6. Расчет времени выполнения метода
//Задача: Реализуйте метод, который измеряет время выполнения
//другого метода (например, цикла из 1 миллиона итераций).
import kotlin.system.measureNanoTime

fun exampleMethod() {
    var sum = 0
    while (sum != 1000000) {
        sum++
    }
    println("Сумма: $sum")
}

fun main() {
    val time = measureNanoTime { exampleMethod() }
    println("Время выполнения: $time наносекунд")
}
