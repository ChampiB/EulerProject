package page1

import helper.MathHelper

object problem_024 extends App {
  def run():String = {
    s"${MathHelper.get_all_permutations("0123456789")(999999)}"
  }
  println(s"Result = ${run()}")
}
