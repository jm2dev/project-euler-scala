package com.jm2dev.projecteuler

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers

class Problem1Tests extends Spec 
  with GivenWhenThen 
  with ShouldMatchers
{
  describe("Multiples of 3 and 5 less than 10") {
    it ("3, 5, 6 and 9 are found") {
      given("the first ten natural numbers")
      
      val tenFirstNumbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

      when("I find the multiples of 3 and 5")
      
      val multiplesOfThreeAndFive = tenFirstNumbers.filter(multipleOfThreeOrFive(_))

      then("the expected result is 3, 5, 6 and 9") 
      
      val expected = List(3, 5, 6, 9)
      multiplesOfThreeAndFive should be(expected)     
    }

    it ("the sum of the found numbers is 23") {
      given("the list of multiples of 3 and 5 less than 10")
      val tenFirstNumbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
      val multiplesOfThreeAndFive = tenFirstNumbers.filter(multipleOfThreeOrFive(_))

      when("I sum all of them")
      
      val actual = multiplesOfThreeAndFive.foldLeft(0)((m: Int, n: Int) => m + n)

      then("the result is 23")

      val expected = 23
      actual should be(expected)
    }

    describe("accumulator for multiples of 3 and 5")
    {
      it("returns 23 for the natural numbers less than 10") {
        given("the upper limit is 10")
        when("I get the sum of multiples of 3 and or 5")
        val actual = new Problem1(10).sumMultiplesOfTheeAndOrFive

        then("I get 23")
        actual should be(23)
      }

      it("returns 3 for the natural numbers less than 4") {
        given("the upper limit is 4")
        when("I get the sum of multiples of 3 and or 5")
        val actual = new Problem1(4).sumMultiplesOfTheeAndOrFive

        then("I get 3")
        actual should be(3)
      }
    }
    
  }

  private def multipleOfThreeOrFive(number: Int): Boolean = {
    ( ( number % 3 == 0 ) | ( number % 5 == 0 ) )
  }

}
