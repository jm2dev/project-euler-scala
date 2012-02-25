package com.jm2dev.projecteuler

object Main extends App {

  private val description = "If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000."

  Console.println("Project Euler: Problem 1")

  Console.println(description)

  val value = new Problem1(1000).sumMultiplesOfTheeAndOrFive
  Console.println("And the value is: " + value)
}
