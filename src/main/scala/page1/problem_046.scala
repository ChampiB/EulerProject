package page1

import helper.MathHelper

object problem_046 extends App {
  def run():String = {
    val primes = MathHelper.get_primes_bellow(100000)
      .zipWithIndex
      .filter{case(is_prime, _) => is_prime}
      .map{case(_, index) => index + 1L}
    val squares = for (i <- 1 to 100000) yield i * i
    var i = 1
    var again = true
    while (again) {
      i += 2
      if (MathHelper.is_composite_number(i)) {
        val values = for (p <- primes) yield {
          var tmp = i - p
          if (tmp % 2 == 0) {
            tmp /= 2
            var i = 0
            while (squares(i) < tmp) i += 1
            squares(i) == tmp
          } else { false }
        }
        again = values.contains(true)
      }
    }
    s"$i"
  }
  println(s"Result = ${run()}")
}
