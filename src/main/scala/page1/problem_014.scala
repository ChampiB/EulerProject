package page1

import helper.MathHelper

object problem_014 extends App {
  def run():String = {
    val lengths = for (i <- 1 to 1000000) yield MathHelper.get_collatz_sequence(i).length
    s"${lengths.indexOf(lengths.max) + 1}"
  }
  println(s"Result = ${run()}")
}
