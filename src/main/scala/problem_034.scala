import helper.{InfiniteNumbersHelper, MathHelper}

object problem_034 extends App {
  def run():String = {
    val results = for (n <- 3 to 1000000) yield {
      val digits_factorial = for (d <- n.toString) yield InfiniteNumbersHelper.factorial(d.toString)
      val sum_digits_factorial = digits_factorial.reduce(InfiniteNumbersHelper.add)
      if (n.toString == sum_digits_factorial) n.toString else "0"
    }
    s"${results.reduce(InfiniteNumbersHelper.add)}"
  }
  println(s"Result = ${run()}")
}
