import helper.{InfiniteNumbersHelper, MathHelper}

object problem_030 extends App {
  var results = for (n <- 2 to 1000000) yield {
    val digits_power = for (d <- n.toString) yield InfiniteNumbersHelper.pow(d.toString, "5")
    val sum_digits_power = digits_power.reduce(MathHelper.infinite_add)
    if (sum_digits_power == n.toString) sum_digits_power else "0"
  }
  println(s"Result = ${results.reduce(MathHelper.infinite_add)}")
}
