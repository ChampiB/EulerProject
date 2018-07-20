import helper.MathHelper

object problem_029 extends App {
  var results = Array[String]()
  var a = "2"
  while (a != "101") {
    var b = "2"
    while (b != "101") {
      results = Array[String](MathHelper.infinite_pow(a, b)) ++ results
      b = MathHelper.infinite_add(b, "1")
    }
    a = MathHelper.infinite_add(a, "1")
  }
  println(s"Result = ${results.distinct.length}")
}
