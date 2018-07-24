import helper.MathHelper

object problem_012 extends App {
  def run():String = {
    var i = 1
    while (MathHelper.get_divisors(MathHelper.get_triangle_number(i)).length <= 500) {
      i = i + 1
    }
    s"${MathHelper.get_triangle_number(i)}"
  }
  println(s"Result = ${run()}")
}
