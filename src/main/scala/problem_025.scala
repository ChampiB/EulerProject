import helper.MathHelper

object problem_025 extends App {
  var result = ("1", "1")
  var i = 2
  while (result._1.length != 1000) {
    val n = MathHelper.infinite_add(result._1, result._2)
    result = (n, result._1)
    i = i + 1
  }
  println(s"Result = $i")
}
