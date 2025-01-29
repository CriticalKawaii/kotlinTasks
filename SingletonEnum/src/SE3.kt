//Enum
//Задача 3.
//Реализация статусов заказа:
//Создайте Enum для статусов заказа в интернет-магазине: NEW, IN_PROGRESS,
//DELIVERED, CANCELLED. Реализуйте класс Order, который будет хранить информацию о
//заказе и текущем статусе, а также методы для смены статуса.
//Требования:
//Определите Enum для статусов заказа.
//Реализуйте методы в классе Order для изменения и отображения статуса заказа.
//Реализуйте логику проверки переходов статусов, чтобы нельзя было отменить доставленный заказ.

enum class OrderStatus {
    NEW,
    IN_PROGRESS,
    DELIVERED,
    CANCELLED
}

class Order(private val orderId: Int, private var status: OrderStatus = OrderStatus.NEW) {
    fun getStatus(): OrderStatus {
        return status
    }
    fun changeStatus(newStatus: OrderStatus) {
        when (status) {
            OrderStatus.NEW -> {
                if (newStatus == OrderStatus.IN_PROGRESS || newStatus == OrderStatus.CANCELLED) {
                    status = newStatus
                } else {
                    throw IllegalStateException("Invalid status transition from NEW to $newStatus")
                }
            }
            OrderStatus.IN_PROGRESS -> {
                if (newStatus == OrderStatus.DELIVERED || newStatus == OrderStatus.CANCELLED) {
                    status = newStatus
                } else {
                    throw IllegalStateException("Invalid status transition from IN_PROGRESS to $newStatus")
                }
            }
            OrderStatus.DELIVERED -> {
                throw IllegalStateException("Cannot change status from DELIVERED")
            }
            OrderStatus.CANCELLED -> {
                throw IllegalStateException("Cannot change status from CANCELLED")
            }
        }
        println("Order $orderId status changed to $status")
    }
    fun displayStatus() {
        println("Order $orderId is currently $status")
    }
}

fun main() {
    val order = Order(1)

    order.displayStatus()
    order.changeStatus(OrderStatus.IN_PROGRESS)

    try {
        order.changeStatus(OrderStatus.NEW)
    } catch (e: IllegalStateException) {
        println(e.message)
    }

    order.changeStatus(OrderStatus.DELIVERED)

    try {
        order.changeStatus(OrderStatus.CANCELLED)
    } catch (e: IllegalStateException) {
        println(e.message)
    }

    order.displayStatus()
}