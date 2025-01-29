//Задача 2.
//Логирование в системе:
//Создайте класс для системы логирования, который реализует паттерн Singleton.
//Класс должен сохранять все сообщения логов в список и предоставлять метод для их вывода.
//Требования:
//Класс должен быть Singleton.
//Реализуйте метод для добавления сообщений в логи.
//Реализуйте метод для вывода всех логов.
object Logger {
    private val logs = mutableListOf<String>()
    fun log(message: String) {
        logs.add(message)
    }
    fun printLogs() {
        println("Logs:")
        logs.forEach { println(it) }
    }
}

fun main() {
    Logger.log("Application started")
    Logger.log("User logged in")
    Logger.log("Data saved successfully")
    Logger.printLogs()
}