import helper.MathHelper

object problem_007 extends App {
  def run():String = {
    var index = 0
    var number = 1
    while (index != 10001) {
      number = number + 1
      if (MathHelper.is_prime(number))
        index = index + 1
    }
    s"$number"
  }
  println(s"Result = ${run()}")
}
