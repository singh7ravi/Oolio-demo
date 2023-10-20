package com.example.myapplication.ui

import com.example.myapplication.ui.slideshow.Customer
import com.example.myapplication.ui.slideshow.PizzaCategory
import com.example.myapplication.ui.slideshow.PizzaType

/*
data class Pizza(val name: String, val description: String, val retailPrice: Double)
data class Customer(val name: String, val specialPricingRule: PricingRule)
data class Order(val customer: Customer, val pizzas: List<Pizza>)
enum class PricingRule {
    NONE, // Default rule
    BUY_2_GET_3_FOR_SMALL,
    DISCOUNT_ON_LARGE,
    BUY_4_GET_5_FOR_MEDIUM
}

fun calculateTotalPrice(order: Order): Double {
    return order.pizzas.sumByDouble { pizza ->
        when (order.customer.specialPricingRule) {
            PricingRule.BUY_2_GET_3_FOR_SMALL -> {
                if (pizza.name == "Small Pizza") {
                    (order.pizzas.count { it.name == "Small Pizza" } / 3 + 1) * pizza.retailPrice
                } else {
                    pizza.retailPrice
                }
            }
            PricingRule.DISCOUNT_ON_LARGE -> {
                if (pizza.name == "Large Pizza") {
                    19.99
                } else {
                    pizza.retailPrice
                }
            }
            PricingRule.BUY_4_GET_5_FOR_MEDIUM -> {
                if (pizza.name == "Medium Pizza") {
                    val mediumPizzaCount = order.pizzas.count { it.name == "Medium Pizza" }
                    if (mediumPizzaCount == 5) {
                        (pizza.retailPrice * 4 / 5)
                    } else {
                        pizza.retailPrice * mediumPizzaCount
                    }
                  //  (order.pizzas.count { it.name == "Medium Pizza" } / 4 * 5) * pizza.retailPrice

                  //  (pizza.retailPrice * 4 / 5)
                } else {
                    pizza.retailPrice
                }
            }
            else -> pizza.retailPrice
        }
    }
}*/
/*
fun main() {
    println("Hi Ravi..")
    val smallPizza = Pizza("Small Pizza", "10'' pizza for one person", 11.99)
    val mediumPizza = Pizza("Medium Pizza", "12'' Pizza for two persons", 15.99)
    val largePizza = Pizza("Large Pizza", "15'' Pizza for four persons", 21.99)

    val microsoft = Customer("Microsoft", PricingRule.BUY_2_GET_3_FOR_SMALL)
    val amazon = Customer("Amazon", PricingRule.DISCOUNT_ON_LARGE)
    val facebook = Customer("Facebook", PricingRule.BUY_4_GET_5_FOR_MEDIUM)
    val defaultCustomer = Customer("Default Customer", PricingRule.NONE)

    val order1 = Order(microsoft, listOf(smallPizza, smallPizza, smallPizza))//, mediumPizza))
    val order2 = Order(amazon, listOf(largePizza, largePizza, largePizza, smallPizza))
    val order3 = Order(facebook, listOf(mediumPizza, mediumPizza, mediumPizza, mediumPizza, mediumPizza,mediumPizza))
    val order4 = Order(defaultCustomer, listOf(smallPizza, mediumPizza, largePizza))

    val total1 = calculateTotalPrice(order1)
    val total2 = calculateTotalPrice(order2)
    val total3 = calculateTotalPrice(order3)
    val total4 = calculateTotalPrice(order4)

   // println("Total Price for Microsoft: $$total1") // wrong
 //   println("Total Price for Amazon: $$total2") // Accurate order
    println("Total Price for Facebook: $$total3")

   // println("Total Price for Default: $$total4")// Accurate
}*/


fun main() {

    val pizzaCategory = PizzaCategory()
    val list = pizzaCategory.getProducts(PizzaType.SMALL_PIZZA, 4)

    val customerName1 = "Microsoft"

    val total1 = pizzaCategory.calculateTotalAmount(customerName1, list)
    println("Case #1 $customerName1 Total: $$total1")


   /* val customerName1 = "default"
    val items1 = listOf(smallPizza, smallPizza, smallPizza, mediumPizza, mediumPizza, mediumPizza, mediumPizza , mediumPizza, mediumPizza, largePizza, largePizza)
    val total1 = calculateTotal(customerName1, items1)
    println("Case #1 $customerName1 Total: $$total1")
    // correct logic for - DEFALUT

    val customerName2 = "Microsoft"
    val items2 = listOf(smallPizza, smallPizza, smallPizza, mediumPizza, mediumPizza, mediumPizza, mediumPizza , mediumPizza, mediumPizza, largePizza, largePizza)
    val total2 = calculateTotal(customerName2, items2)
    println("Case #2 $customerName2 Total: $$total2")
        // correct logic for - Microsoft


    val customerName3 = "Amazon"
    val items3 = listOf(smallPizza, smallPizza, smallPizza, mediumPizza, mediumPizza, mediumPizza, mediumPizza , mediumPizza, mediumPizza, largePizza, largePizza)
    val total3 = calculateTotal(customerName3, items3)
    println("Case #3 $customerName3 Total: $$total3")

    val customerName4 = "Facebook"
    val items4 = listOf(smallPizza, smallPizza, smallPizza, mediumPizza, mediumPizza, mediumPizza, mediumPizza , mediumPizza, mediumPizza, largePizza, largePizza)
    val total4 = calculateTotal(customerName4, items4)
    println("Case #4 $customerName4 Total: $$total4") */
}
