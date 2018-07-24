import helper.{InfiniteNumbersHelper, MathHelper}

object problem_029 extends App {
  def run():String = {
    var results = Array[String]()
    var a = "2"
    while (a != "101") {
      var b = "2"
      while (b != "101") {
        results = Array[String](InfiniteNumbersHelper.pow(a, b)) ++ results
        b = InfiniteNumbersHelper.add(b, "1")
      }
      a = InfiniteNumbersHelper.add(a, "1")
    }
    s"${results.distinct.length}"
  }
  println(s"Result = ${run()}")
}
