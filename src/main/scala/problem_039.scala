import helper.MathHelper

object problem_039 extends App {
  def get_number_of_pythagorean_equal_to(i:Int): Int = {
    var result = 0
    for (a <- 0 to i) {
      for (b <- 0 to i) {
        val c = i - a - b
        if (a < b && b < c && a + b + c == i && MathHelper.is_pythagorean(a, b, c))
          result += 1
      }
    }
    result
  }
  def run():String = {
    var result_value = -1
    var result_id = -1
    for (i <- 0 to 1000) {
      val n = get_number_of_pythagorean_equal_to(i)
      if (n > result_value) {
        result_value = n
        result_id = i
      }
    }
    s"$result_id"
  }
  println(s"Result = ${run()}")
}
