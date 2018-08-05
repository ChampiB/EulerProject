package page1

import helper.MathHelper

object problem_041 extends App {
  def run():String = {
    val s = "123456789"
    val results = for (it <- 1 to s.length) yield {
      val permutations = MathHelper.get_all_permutations(s.substring(0, it))
      var again = true
      var i = permutations.length - 1
      while (i != -1 && again) {
        if (MathHelper.is_prime(permutations(i).toLong)) {
          again = false
        } else {
          i -= 1
        }
      }
      if (i == -1) "0" else permutations(i)
    }
    results.map(_.toLong).max.toString
  }
  println(s"Result = ${run()}")
}
