package com.jm2dev.projecteuler

class Fibonacci() {

  def generate(topValue: Int): List[Int] = {
    def calculate(lista: List[Int]): List[Int] = {
      if ( lista.last > topValue ) 
        return lista.reverse.tail.reverse
      else {
        val candidate = addThem(lista)
        calculate( candidate )
      }
    }

    calculate(List(1))    
  }

  def build(numberOfElements: Int): List[Int] = {
    
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
