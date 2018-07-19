import helper.MathHelper

object problem_010 extends App {
  val are_primes = MathHelper.get_primes_bellow(2000000)
  val primes = for (n <- 0 until 2000000) yield if (are_primes(n)) n + 1L else 0L
  println(s"Result = ${primes.sum}")
}
