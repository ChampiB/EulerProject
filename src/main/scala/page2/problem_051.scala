package page2

import helper.MathHelper

object problem_051 extends App {
  var result = -1L
  val REPLACE_CHAR = 'r'
  def get_all_replacements(n:String, start:Array[String] = Array[String]()):Array[String] = {
    if (n.isEmpty) {
      start
    } else if (start.isEmpty) {
      get_all_replacements(n drop 1, Array(n(0).toString, s"$REPLACE_CHAR"))
    } else {
      val new_start = start.flatMap{r => Array(r + n(0), r + REPLACE_CHAR)}
      get_all_replacements(n drop 1, new_start)
    }
  }
  def belongs_to_eight_prime_value_family(n:Long):Boolean = {
    val replacements = get_all_replacements(n.toString)
      .filter{r => r.count(_ == REPLACE_CHAR) != r.length}
    val values = for (replacement <- replacements) yield {
      val numbers = for (d <- '0' to '9') yield {
        val r = replacement.replaceAll(s"$REPLACE_CHAR", s"$d")
        if (r(0) == '0') { 1L } else { r.toLong }
      }
      if (numbers.map(MathHelper.is_prime).count(_ == true) == 8) {
        result = numbers.filter(_ != 1L).min
        true
      } else {
        false
      }
    }
    values.contains(true)
  }
  def run():String = {
    var i = 0
    while (!belongs_to_eight_prime_value_family(i))
      i += 1
    result.toString
  }
  println(s"Result = ${run()}")
}
