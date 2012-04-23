package com.jm2dev.projecteuler

import org.scalatest.{GivenWhenThen, Spec}
import org.scalatest.matchers.ShouldMatchers

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/
 
class Problem4Tests extends Spec
  with GivenWhenThen
  with ShouldMatchers
{
  describe("palindrome")
  {
    it("detects a number which reads the same both ways")
    {
      given("121")
      val palindrome =  new Palindrome(121)

      when("I check whether is a palindromic number")
      val actual = palindrome.isIt

      then("I get it is!")
      actual should be(true)
    }

    it("detects a number which is not palindromic")
    {
      given("122")
      val number = new Palindrome(122)

      when("I check its palindromicity")
      val actual = number.isIt

      then("I get it is not")
      actual should be(false)
    }
  }

  describe("finds biggest palindromic number product of two numbers")
  {
    it("finds 9009 = 91 * 99")
    {
      given("I calculate the product of two 2-digit numbers")
      val decenas = Range(9,100,10).toList.reverse
      val unidades = Range(91,100).toList.reverse

      when("I want the biggest palindramic number")
      val actual = decenas.map( (d: Int) => {
        unidades.map( (u:Int) => {
          d * u
        })
      }).flatten

      then("I get 9009")
      actual.find(new Palindrome(_).isIt == true).get should be(9009)
    }

    it("finds 906609")
    {
      given("I calculate the product of two 3-digit numbers")
      val decenas = Range(99,1000,1).toList.reverse
      val unidades = Range(901,1000).toList.reverse

      when("I want the biggest palindramic number")
      val actual = decenas.map( (d: Int) => {
        unidades.map( (u:Int) => {
          d * u
        })
      }).flatten

      then("I get 906609")
      actual.find(new Palindrome(_).isIt == true).getOrElse(0) should be(906609)
    }
  }
}

class Palindrome(number: Int) 
{
  def isIt: Boolean = {
    val reverse = number.toString.toCharArray.reverse.mkString("")
    val candidate = number.toString.toCharArray.mkString("")
    
    if ( reverse == candidate )
      true
    else
      false
  }
}
