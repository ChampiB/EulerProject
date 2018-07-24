import helper.{InfiniteNumbersHelper, MathHelper}

object problem_025 extends App {
  def run():String = {
    var result = ("1", "1")
    var i = 2
    while (result._1.length != 1000) {
      val n = InfiniteNumbersHelper.add(result._1, result._2)
      result = (n, result._1)
      i = i + 1
    }
    s"$i"
  }
  println(s"Result = ${run()}")
}
