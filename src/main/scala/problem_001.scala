object problem_001 extends App {
  def run():String = {
    val multiple_of_3 = for (i <- 3 until 1000 by 3) yield i
    val multiple_of_5 = for (i <- 5 until 1000 by 5) yield i
    val multiple_of_3_and_5 = multiple_of_3 ++ multiple_of_5
    s"${multiple_of_3_and_5.distinct.sum}"
  }
  println(s"Result = ${run()}")
}
