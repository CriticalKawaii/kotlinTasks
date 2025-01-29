//Задача 1.
//Создание класса базы данных:
//Реализуйте класс, который будет представлять подключение к базе данных.
//Класс должен быть реализован как Singleton,
//чтобы при каждом обращении возвращался один и тот же объект.
//Требования:
//Класс должен быть Singleton.
//Метод подключения должен выводить сообщение о создании подключения.
//Проверьте, что при создании нескольких экземпляров — они ссылаются на один и тот же объект.
class Database private constructor() {
    init {
        println("Database connection created")
    }
    companion object {
        val instance: Database by lazy {
            Database()
        }
    }
    fun connect() {
        println("Connected to the database")
    }
}
fun main() {
    val db1 = Database.instance
    val db2 = Database.instance

    println(db1 === db2)
    db1.connect()
    db2.connect()
}