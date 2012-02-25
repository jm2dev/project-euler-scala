package com.jm2dev.projecteuler

class Problem1(upperLimit: Int) {

  def sumMultiplesOfTheeAndOrFive(): Int = {
    val initialList = List.range(1, upperLimit)
    val multiplesOfThreeAndFive = initialList.filter(multipleOfThreeOrFive(_))
    multiplesOfThreeAndFive.foldLeft(0)((m: Int, n: Int) => m + n)
  }

  private def multipleOfThreeOrFive(number: Int): Boolean = {
    ( ( number % 3 == 0 ) | ( number % 5 == 0 ) )
  }
}
