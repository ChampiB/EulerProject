package page1

import helper.InfiniteNumbersHelper

object problem_048 extends App {
  def run():String = {
    val terms = for (n <- 1 to 1000) yield {
      var result = n.toString
      var i = "1"
      while (i != n.toString) {
        result = InfiniteNumbersHelper.mul(result, n.toString).takeRight(10)
        while (result.length != 1 && result(0) == '0') result = result.drop(1)
        i = InfiniteNumbersHelper.add(i, "1")
      }
      result
    }
    var result = terms.reduce(InfiniteNumbersHelper.add).takeRight(10)
    while (result.length != 1 && result(0) == '0') result = result.drop(1)
    s"$result"
  }
  println(s"Result = ${run()}")
}
