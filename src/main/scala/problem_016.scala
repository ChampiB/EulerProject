import helper.InfiniteNumbersHelper

object problem_016 extends App {
  def run():String = {
    val n = InfiniteNumbersHelper.pow("2", "1000")
    val result = n.map { c =>
      val result = c - '0'
      result.toLong
    }.sum
    s"$result"
  }
  println(s"Result = ${run()}")
}
