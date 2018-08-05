package page1

import helper.MathHelper

object problem_009 extends App {
  def run():String = {
    var result = ""
    for (a <- 0 to 1000) {
      for (b <- 0 to 1000) {
        val c = 1000 - a - b
        if (a < b && b < c && a + b + c == 1000 && MathHelper.is_pythagorean(a, b, c))
          result = s"${a * b * c}"
      }
    }
    result
  }
  println(s"Result = ${run()}")
}
