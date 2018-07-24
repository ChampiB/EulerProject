import helper.MathHelper

object problem_035 extends App {
  def run():String = {
    val results = for (i <- 2 to 1000000) yield if (MathHelper.is_circular_prime(i)) 1 else 0
    s"${results.sum}"
  }
  println(s"Result = ${run()}")
}
