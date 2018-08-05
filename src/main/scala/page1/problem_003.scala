package page1

import helper.MathHelper

object problem_003 extends App {
  def run():String = {
    var n = 600851475143L
    var prime_factors = Array[Long]()
    for (i <- 2L to Math.sqrt(n).round) {
      if (n % i == 0 && MathHelper.is_prime(i)) {
        while (n % i == 0) {
          n = n / i
          prime_factors = prime_factors ++ Array[Long](i)
        }
      }
    }
    s"${prime_factors.last}"
  }
  println(s"Result = ${run()}")
}
