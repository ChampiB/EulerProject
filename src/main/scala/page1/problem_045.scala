package page1

import helper.MathHelper

object problem_045 extends App {
  def run():String = {
    val limit = 100000
    val triangles = for (i <- 1 to limit) yield MathHelper.get_triangle_number(i)
    val pentagonals = for (i <- 1 to limit) yield MathHelper.get_pentagonal_number(i)
    val hexagonals = for (i <- 1 to limit) yield MathHelper.get_hexagonal_number(i)
    val res = triangles
      .filter(e => pentagonals.contains(e))
      .filter(e => hexagonals.contains(e))
      .filter(_ > 40755)
      .min
    s"$res"
  }
  println(s"Result = ${run()}")
}
