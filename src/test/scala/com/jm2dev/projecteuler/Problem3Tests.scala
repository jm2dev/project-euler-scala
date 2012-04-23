package com.jm2dev.projecteuler

import org.scalatest.{GivenWhenThen, Spec}
import org.scalatest.matchers.ShouldMatchers


/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/
class Problem3Tests extends Spec
  with GivenWhenThen
  with ShouldMatchers
{
  private val problem3 = new Problem3()
  
  describe("Prime numbers")
  {
    it("should get next prime factor")
    {
      given("2 is the first prime factor")
      val expected = List(2, 3, 5, 7)

      when("I want to get prime factors which are less than 5")
      val actual = problem3.generatePrimeFactor(9, List(2, 3, 5, 7))

      then("I get 2, 3, 5 and 7")
      actual should be(expected)
    }

    it("get prime factors for 13195")
    {
      given("I want to factor 13195")
      val expected = List(5, 7, 13, 29)

      when("I factor it")
      val actual = problem3.factorize(13195)

      then("I get 5, 7, 13, 29")
      actual should be(expected)
    }

    it("get prime factors for 600851475143")
    {
      given("I want to get the largest prime factor for 600851475143")
      val expected = 6857

      when("I factor it")
      val actual = problem3.factorize(600851475143D)

      then("I get ...")
      actual.last should be(expected)
    }
  }
}
