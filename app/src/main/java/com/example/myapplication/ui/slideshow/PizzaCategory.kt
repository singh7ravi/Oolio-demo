package com.example.myapplication.ui.slideshow


enum class PizzaType {
    SMALL_PIZZA,
    MEDIUM_PIZZA,
    LARGE_PIZZA
}

data class Pizza(val name: String, val description: String, val retailPrice: Double)

data class Customer(val name: String, val specialPricing: (List<Pizza>) -> Double)

val smallPizza = Pizza("Small Pizza", "10'' pizza for one person", 11.99)
val mediumPizza = Pizza("Medium Pizza", "12'' Pizza for two persons", 15.99)
val largePizza = Pizza("Large Pizza", "15'' Pizza for four persons", 21.99)


class PizzaCategory constructor() {

    val customers = listOf(
        Customer("default") { items ->
            items.sumByDouble { it.retailPrice }
        },
        Customer("Microsoft") { items ->
            val smallPizzaCount = items.count { it == smallPizza }
            // Logic for Small pizza while ordered by customer: Microsoft
            val remainingSmallPizzas = smallPizzaCount % 3
            val smallPizzaPrice = (smallPizzaCount / 3) * 2 * smallPizza.retailPrice +
                    remainingSmallPizzas * smallPizza.retailPrice

            val largePizzaPrice = items.count { it == largePizza } * largePizza.retailPrice
            val mediumPizzaPrice = items.count { it == mediumPizza } * mediumPizza.retailPrice
            smallPizzaPrice + mediumPizzaPrice + largePizzaPrice
        },
        Customer("Amazon") { items ->
            val mediumPizzaPrice =  items.count { it == mediumPizza } * mediumPizza.retailPrice
            val largePizzaCount = items.count { it == largePizza }
            val smallPizzaPrice = items.count { it == smallPizza } * smallPizza.retailPrice

            // Logic for Large pizza while ordered by customer: Amazon
            val largePizzaPrice = largePizzaCount * 19.99

            smallPizzaPrice + mediumPizzaPrice + largePizzaPrice
        },
        Customer("Facebook") { items ->

            val smallPizzaPrice = items.count { it == smallPizza } * smallPizza.retailPrice
            val mediumPizzaCount = items.count { it == mediumPizza }

            // Logic for Medium pizza while ordered by customer: Facebook
            val mediumPizzaPrice = (mediumPizzaCount / 5) * 4 * mediumPizza.retailPrice +
                    (mediumPizzaCount % 5) * mediumPizza.retailPrice // Logic

            val largePizzaPrice = items.count { it == largePizza } * largePizza.retailPrice

            smallPizzaPrice + mediumPizzaPrice + largePizzaPrice
        }
    )

    fun getProducts(type: PizzaType, quantity: Int): List<Pizza> {
        val list = mutableListOf<Pizza>()
        var retailsPrice: Double = 0.0;
        retailsPrice = when (type) {
            PizzaType.SMALL_PIZZA -> {
                11.99
            }

            PizzaType.MEDIUM_PIZZA -> {
                15.99
            }

            else -> {
                21.99
            }
        }
        for (i in 1..quantity) {
            list.add(Pizza("Small Pizza", "10'' pizza for one person", retailsPrice))
        }
        return list
    }

    fun calculateTotalAmount(customerName: String, items: List<Pizza>): Double {
        val customer = customers.find { it.name == customerName } ?: customers.first { it.name == "default" }
        return customer.specialPricing(items)
    }

}