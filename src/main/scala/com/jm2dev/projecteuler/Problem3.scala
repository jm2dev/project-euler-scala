package com.jm2dev.projecteuler

class Problem3 {
  def factorize(number: Double): List[Int] =
  {
    val upperLimit = math.sqrt(number).toInt + 1
    val candidates = Range(3, upperLimit, 2).toList
    var primes = List(2)

    candidates.map( (candidate: Int) => {
      primes = generatePrimeFactor(candidate, primes)
    } )

    primes.filter( number % _ == 0)
  }

  def generatePrimeFactor(candidate: Int, primes: List[Int]): List[Int] =
  {
    val result = primes.filter( (prime: Int) =>
    {
      candidate % prime != 0
    })

    if ( result.size == primes.size )
      primes ::: List(candidate)
    else
      primes
  }
}
