import helper.MathHelper

object problem_035 extends App {
  val results = for (i <- 2 to 1000000) yield if (MathHelper.is_circular_prime(i)) 1 else 0
  println(s"Result = ${results.sum}")
}
