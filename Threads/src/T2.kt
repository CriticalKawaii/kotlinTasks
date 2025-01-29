//Задание 2: Реализация паттерна Декоратор
//Задача: Реализуйте паттерн Декоратор для обработки текста. Напишите набор классов, которые будут декорировать строку:
//Основной интерфейс TextProcessor, содержащий метод process(String text).
//Реализуйте класс SimpleTextProcessor, который просто возвращает текст без изменений.
//Реализуйте декораторы:
//UpperCaseDecorator — преобразует текст в верхний регистр.
//TrimDecorator — удаляет пробелы в начале и конце строки.
//ReplaceDecorator — заменяет все пробелы символом подчеркивания (_).
//Условия:
//Продемонстрируйте работу декораторов, комбинируя их.
//Пример использования: оберните текст в несколько декораторов и вызовите process.
interface TextProcessor {
    fun process(text: String): String
}

class SimpleTextProcessor : TextProcessor {
    override fun process(text: String) = text
}

class UpperCaseDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String) = processor.process(text).uppercase()
}

class TrimDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String) = processor.process(text).trim()
}

class ReplaceDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String) = processor.process(text).replace(" ", "_")
}

fun main() {
    val processor = ReplaceDecorator(
        UpperCaseDecorator(
            TrimDecorator(SimpleTextProcessor())
        )
    )
    println(processor.process(" Hello world "))
}