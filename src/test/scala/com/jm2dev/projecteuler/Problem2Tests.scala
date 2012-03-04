package com.jm2dev.projecteuler

import org.scalatest.Spec
import org.scalatest.GivenWhenThen
import org.scalatest.matchers.ShouldMatchers

class Problem2Tests extends Spec 
  with GivenWhenThen 
  with ShouldMatchers
{
  describe("Fibonacci sequence") {
    it("should return the first value, 1") {
      given("I have an empty list")
      val expected = List(1)

      when("I calculate the first element")
      val actual = new Fibonacci().build(1)

      then("I get a list of one item, which it's 1")
      actual should be(expected)
    }

    it("should return the first two values") {
      given("I have an empty list")
      val expected = List(1, 2)

      when("I want the first two elements")
      val actual = new Fibonacci().build(2)

      then("I get 1 and 2")
      actual should be(expected)
    }

    it("should return the first four elements") {
      given("I have an empty list")
      val expected = List(1, 2, 3, 5)

      when("I want the first four elements")
      val actual = new Fibonacci().build(4)

      then("I get 1, 2, 3, 5")
      actual should be(expected)
    }

    it("should find the first elements of this sequence: 1, 2, 3, 5, 8, ...") {
      given("1 and 2 as first elements")
      val first = List(1, 2)
      val expected = List(1, 2, 3, 5, 8)

      when("I want the first five elements")
      val actual = new Fibonacci().build(5)

      then("I get 1, 2, 3, 5, 8")
      actual should be(expected)
    }
  }

  describe("Sum even members which its value is less than 10") {
    it("should return members which are less than 10") {
      given("I can generate a Fibonacci sequence of arbitrary length")
      val expected = List(1, 2, 3, 5, 8)

      when("I want the sequence of value less than 10")
      val actual = new Fibonacci().generate(10)

      then("I get 1, 2, 3, 5, 8")
      actual should be(expected)
    }

    it("should return the list of even members less than 10") {
      given("I can generate a Fibonacci sequence of arbitrary length")
      val expected = List(2, 8)

      when("I want to get the list of even mebers with value less than 10")
      val secuencia = new Fibonacci().generate(10)
      val actual = secuencia.filter(_ % 2 == 0)

      then("I get 2, 8")
      actual should be(expected)
    }

    it("should return the sum of even member with value less than 10") {
      given("I can generate a Fibonacci sequence of arbitrary length")
      val expected = 10

      when("I want to sum even memebers with value less than 10")
      val secuencia = new Fibonacci().generate(10)
      val evenValues = secuencia.filter( _ % 2 == 0 )
      val actual = evenValues.foldLeft(0){ (m: Int, n: Int) => m + n }

      then("I get 10")
      actual should be(expected)
    }

    it("solution to problem 2: 4613732") {
      val secuencia = new Fibonacci().generate(4000000)
      val evenValues = secuencia.filter( _ % 2 == 0 )
      val actual = evenValues.foldLeft(0){ (m: Int, n: Int) => m + n }

      actual should be(4613732)
    }
  }

}

