package page1

import helper.MathHelper

object problem_047 extends App {
  def run():String = {
    val primes = MathHelper.get_primes_bellow(150000)
      .zipWithIndex
      .filter{case(is_prime, _) => is_prime}
      .map{case(_, index) => index + 1L}
    var n = 1
    var again = true
    while (again) {
      n += 1
      if (
           MathHelper.get_divisors(n    ).count(primes contains _) == 4
        && MathHelper.get_divisors(n + 1).count(primes contains _) == 4
        && MathHelper.get_divisors(n + 2).count(primes contains _) == 4
        && MathHelper.get_divisors(n + 3).count(primes contains _) == 4
      ) again = false
    }
    s"$n"
  }
  println(s"Result = ${run()}")
}
