import helper.InfiniteNumbersHelper

object problem_016 extends App {
  val n = InfiniteNumbersHelper.pow("2", "1000")
  val result = n.map { c =>
    val result = c - '0'
    result.toLong
  }.sum
  println(s"Result = $result")
}
