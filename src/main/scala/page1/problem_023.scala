package page1

import helper.MathHelper

object problem_023 extends App {
  def run():String = {
    val numbers = for (n <- 1 to 28123) yield if (MathHelper.is_abundant_number(n)) n else 0
    val abundant_numbers = numbers.filter(_ != 0)
    val results = for (n <- 1 to 28123) yield {
      var again = true
      var i = 0
      var res = 0
      while (again) {
        if (i >= abundant_numbers.length || abundant_numbers(i) >= n) {
          res = n
          again = false
        } else if (abundant_numbers.contains(n - abundant_numbers(i))) {
          res = 0
          again = false
        }
        i = i + 1
      }
      res
    }
    s"${results.sum}"
  }
  println(s"Result = ${run()}")
}
