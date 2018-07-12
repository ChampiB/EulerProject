object problem_001 extends App {
  val multiple_of_3 = for (i <- 3 to 1000 by 3) yield i
  val multiple_of_5 = for (i <- 5 to 1000 by 5) yield i
  val multiple_of_3_and_5 = multiple_of_3 ++ multiple_of_5
  println(s"Result = ${multiple_of_3_and_5.distinct.sum}")
}
