package page1

import helper.MathHelper

object problem_049 extends App {
  def run():String = {
    val step = 3330
    var res = ""
    var again = true
    var i = 1
    while (again && i + 2 * step < 10000L) {
      if (
        MathHelper.are_permutations(Array(i.toString, (i + step).toString, (i + 2 * step).toString)) &&
        MathHelper.is_prime(i) &&
        MathHelper.is_prime(i + step) &&
        MathHelper.is_prime(i + 2 * step) &&
        i != 1487
      ) {
        again = false
        res = s"$i${i + step}${i + 2 * step}"
      }
      i += 1
    }
    s"$res"
  }
  println(s"Result = ${run()}")
}
