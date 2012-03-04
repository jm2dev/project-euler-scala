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
      val actual = new Fibonacci(1).build

      then("I get a list of one item, which it's 1")
      actual should be(expected)
    }

    it("should return the first two values") {
      given("I have an empty list")
      val expected = List(1, 2)

      when("I want the first two elements")
      val actual = new Fibonacci(2).build

      then("I get 1 and 2")
      actual should be(expected)
    }

    it("should return the first four elements") {
      given("I have an empty list")
      val expected = List(1, 2, 3, 5)

      when("I want the first four elements")
      val actual = new Fibonacci(4).build

      then("I get 1, 2, 3, 5")
      actual should be(expected)
    }

    it("should find the first elements of this sequence: 1, 2, 3, 5, 8, ...") {
      given("1 and 2 as first elements")
      val first = List(1, 2)
      val expected = List(1, 2, 3, 5, 8)

      when("I want the first five elements")
      val actual = new Fibonacci(5).build

      then("I get 1, 2, 3, 5, 8")
      actual should be(expected)
    }
  }
}

class Fibonacci(numberOfElements: Int) {

  def build(): List[Int] = {
    
    def calculate(lista: List[Int]): List[Int] = {
      if ( lista.size == numberOfElements ) 
        return lista
      else {
        val candidate = addThem(lista)
        calculate( candidate )
      }
    }

    calculate(List())
  }

  private def addThem(lista: List[Int]): List[Int] = {
    if ( lista.isEmpty ) List(1)
    else if ( lista.size == 1) List(1, 2)
    else {
      val next = lista.last + lista.reverse.tail.head
      lista ::: List(next)
    } 
  }
}
