package page1

import helper.MathHelper

object problem_021 extends App {
  def run():String = {
    val result = for (i <- 1 until 10000) yield {
      val n = MathHelper.get_divisors(i).sum - i
      if (MathHelper.get_divisors(n).sum - n == i && n != i) i else 0
    }
    s"${result.sum}"
  }
  println(s"Result = ${run()}")
}
