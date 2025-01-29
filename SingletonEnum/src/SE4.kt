//Задача 4.
//Сезоны года:
//Создайте Enum, представляющий времена года: WINTER, SPRING, SUMMER, AUTUMN.
//Затем реализуйте функцию, которая принимает значение этого Enum
//и возвращает соответствующее название сезона на русском языке.
//Требования:
//Определите Enum для сезонов.
//Реализуйте метод, который принимает сезон и возвращает строку с его названием.
enum class Season{
    WINTER, SPRING, SUMMER, AUTUMN
}
fun getSeasonNameInRussian(season: Season): String {
    return when (season) {
        Season.WINTER -> "Зима"
        Season.SPRING -> "Весна"
        Season.SUMMER -> "Лето"
        Season.AUTUMN -> "Осень"
    }
}

fun main() {
    val winter = Season.WINTER
    val spring = Season.SPRING
    val summer = Season.SUMMER
    val autumn = Season.AUTUMN

    println("${winter.name} на русском: ${getSeasonNameInRussian(winter)}")
    println("${spring.name} на русском: ${getSeasonNameInRussian(spring)}")
    println("${summer.name} на русском: ${getSeasonNameInRussian(summer)}")
    println("${autumn.name} на русском: ${getSeasonNameInRussian(autumn)}")
}