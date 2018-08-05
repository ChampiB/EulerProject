package page1

import helper.MathHelper

object problem_050 extends App {
  def get_sum_of_consecutive_primes(primes:Array[Long], i:Int, length:Int):Long = {
    val consecutive_primes = for (index <- i until i + length) yield primes(index)
    consecutive_primes.sum
  }
  def run():String = {
    val limit = 1000000
    val primes = MathHelper.get_primes_bellow(limit)
      .zipWithIndex
      .filter{case(is_prime, _) => is_prime}
      .map{case(_, index) => index + 1L}
    var sum_length = primes.length
    var again = true
    var res = ""
    while (again) {
      var i = 0
      var sum = get_sum_of_consecutive_primes(primes, i, sum_length)
      while (again && sum_length + i < primes.length) {
        if (sum < limit && primes.contains(sum)) {
          again = false
          res = sum.toString
        }
        if (sum_length + i < primes.length)
          sum = sum - primes(i) + primes(i + sum_length)
        i += 1
      }
      sum_length -= 1
    }
    s"$res"
  }
  println(s"Result = ${run()}")
}
