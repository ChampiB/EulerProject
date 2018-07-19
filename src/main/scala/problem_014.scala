import helper.MathHelper

object problem_014 extends App {
  val lengths = for (i <- 1 to 1000000) yield MathHelper.get_collatz_sequence(i).length
  println(s"Result = ${lengths.indexOf(lengths.max) + 1}")
}
