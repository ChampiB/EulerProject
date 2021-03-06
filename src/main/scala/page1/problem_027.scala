package page1

import helper.MathHelper

object problem_027 extends App {
  def run():String = {
    var result = (0, 0, -1)
    for (a <- -999 to 999) {
      for (b <- -1000 to 1000) {
        var n = 0
        while (MathHelper.is_prime(Math.pow(n, 2).toLong + a * n + b))
          n += 1
        if (n > result._3)
          result = (a, b, n)
      }
    }
    s"${result._1 * result._2}"
  }
  println(s"Result = ${run()}")
}
