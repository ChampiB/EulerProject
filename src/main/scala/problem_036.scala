import helper.{InfiniteNumbersHelper, MathHelper}

object problem_036 extends App {
  val results = for (i <- 1 until 1000000) yield {
    val i_10 = i.toString
    val i_2 = MathHelper.convert_base_from_base_10(i_10, "01")
    if (InfiniteNumbersHelper.is_palindrome(i_10) && InfiniteNumbersHelper.is_palindrome(i_2)) i_10 else "0"
  }
  println(s"Result = ${results.reduce(InfiniteNumbersHelper.add)}")
}
