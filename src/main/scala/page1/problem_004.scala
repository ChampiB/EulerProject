package page1

import helper.MathHelper

object problem_004 extends App {
  def check_product_of_two_3_digit(i:Int):Unit = {
    for (n1 <- 999 to 100 by -1)
      if (i % n1 == 0 && s"${i / n1}".toString.length == 3)
        throw new Exception(s"$i")
  }
  def run():String = {
    var result = ""
    try {
      for (i <- 999 * 999 to 0 by -1)
        if (MathHelper.is_palindrome(i))
          check_product_of_two_3_digit(i)
    } catch {
      case e:Exception => result = e.getMessage
    }
    result
  }
  println(s"Result = ${run()}")
}
