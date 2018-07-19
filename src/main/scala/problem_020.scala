import helper.MathHelper

object problem_020 extends App {
  val result = MathHelper.infinite_factorial("100")
  println(s"Result = ${result.map(_ - '0').sum}")
}
