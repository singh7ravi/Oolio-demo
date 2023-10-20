package com.example.myapplication.presentation.corelogic

fun main() {

    val pizzaCategory = PizzaCategory()
    val list01 = pizzaCategory.getProducts(PizzaType.SMALL_PIZZA, 4)

    val customerName01 = "Microsoft"

    val total01 = pizzaCategory.calculateTotalAmount(customerName01, list01)
    println("Case 0 # $customerName01 Total: $$total01")


    val customerName02 = "default"
    val items1 = listOf(smallPizza, smallPizza, smallPizza, mediumPizza, mediumPizza, mediumPizza, mediumPizza , mediumPizza, mediumPizza, largePizza, largePizza)
    val total1 = pizzaCategory.calculateTotalAmount(customerName02, items1)
    println("Case #1 $customerName02 Total: $$total1")
    // correct logic for - DEFALUT

    val customerName03 = "Microsoft"
    val items2 = listOf(smallPizza, smallPizza, smallPizza, mediumPizza, mediumPizza, mediumPizza, mediumPizza , mediumPizza, mediumPizza, largePizza, largePizza)
    val total2 = pizzaCategory.calculateTotalAmount(customerName03, items2)
    println("Case #2 $customerName03 Total: $$total2")
        // correct logic for - Microsoft


    val customerName04 = "Amazon"
    val items3 = listOf(smallPizza, smallPizza, smallPizza, mediumPizza, mediumPizza, mediumPizza, mediumPizza , mediumPizza, mediumPizza, largePizza, largePizza)
    val total3 = pizzaCategory.calculateTotalAmount(customerName04, items3)
    println("Case #3 $customerName04 Total: $$total3")

    val customerName05 = "Facebook"
    val items4 = listOf(smallPizza, smallPizza, smallPizza, mediumPizza, mediumPizza, mediumPizza, mediumPizza , mediumPizza, mediumPizza, largePizza, largePizza)
    val total4 = pizzaCategory.calculateTotalAmount(customerName05, items4)
    println("Case #4 $customerName05 Total: $$total4")
}
