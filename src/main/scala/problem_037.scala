import helper.MathHelper

object problem_037 extends App {
  def run():String = {
    var results = Array[Long]()
    var i = 11L
    while (results.length != 11L) {
      if (MathHelper.is_truncatable_prime(i))
        results = results ++ Array(i)
      i += 2L
    }
    s"${results.sum}"
  }
  println(s"Result = ${run()}")
}
