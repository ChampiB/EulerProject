package page2

import helper.InfiniteNumbersHelper

object problem_053 extends App {
  def run():String = {
    val factorials = for (i <- 0 to 100) yield InfiniteNumbersHelper.factorial(i.toString)
    val results = for (n <- 1 to 100) yield {
      val tmp = for (k <- 1 to n) yield {
        val a = InfiniteNumbersHelper.among(k.toString, n.toString, factorials.toArray)
        InfiniteNumbersHelper.is_superior(a, "1000000")
      }
      println(n)
      tmp
    }
    results.flatten.count(_ == true).toString
  }
  println(s"Result = ${run()}")
}
