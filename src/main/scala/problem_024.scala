import helper.MathHelper

object problem_024 extends App {
  println(s"Result = ${MathHelper.get_all_permutations("0123456789")(999999)}")
}
