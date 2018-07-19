import helper.MathHelper

object problem_012 extends App {
  var i = 1
  while (MathHelper.get_divisors(MathHelper.get_triangle_number(i)).length <= 500) {
    i = i + 1
  }
  println(s"Result = ${MathHelper.get_triangle_number(i)}")
}
