import helper.{InfiniteNumbersHelper, MathHelper}

object problem_034 extends App {
  val results = for (n <- 3 to 1000000) yield {
    val digits_factorial = for (d <- n.toString) yield InfiniteNumbersHelper.factorial(d.toString)
    val sum_digits_factorial = digits_factorial.reduce(MathHelper.infinite_add)
    if (n.toString == sum_digits_factorial) n.toString else "0"
  }
  println(s"Result = ${results.reduce(MathHelper.infinite_add)}")
}
