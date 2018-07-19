import helper.MathHelper

object problem_021 extends App {
  val result = for (i <- 1 until 10000) yield {
    val n = MathHelper.get_divisors(i).sum - i
    if (MathHelper.get_divisors(n).sum - n == i && n != i) i else 0
  }
  println(s"Result = ${result.sum}")
}
