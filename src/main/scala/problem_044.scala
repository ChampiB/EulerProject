import helper.MathHelper

object problem_044 extends App {
  def run():String = {
    val limit = 5000
    val pentagonals = for (i <- 1 to 2 * limit) yield MathHelper.get_pentagonal_number(i)
    val values = for (n <- 1 to limit) yield {
      for (k <- 1 to limit) yield {
        val minus = pentagonals(n + k - 1) - pentagonals(n - 1)
        val plus  = pentagonals(n + k - 1) + pentagonals(n - 1)
        if (MathHelper.is_pentagonal_number(minus) && MathHelper.is_pentagonal_number(plus)) minus else -1L
      }
    }
    s"${values.flatten.filter(_ > 0L).min}"
  }
  println(s"Result = ${run()}")
}
