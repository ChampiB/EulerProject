import helper.MathHelper

object problem_016 extends App {
  val n = MathHelper.infinite_pow("2", "1000")
  val result = n.map { c =>
    val result = c - '0'
    result.toLong
  }.sum
  println(s"Result = $result")
}
