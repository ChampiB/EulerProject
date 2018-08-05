package page1

object problem_002 extends App {
  def run():String = {
    val fibonacci_state = Array[Long](1, 2, 2) // (n-2, n-1, sum)
    while (fibonacci_state(0) + fibonacci_state(1) < 4000000) {
      val n = fibonacci_state(0) + fibonacci_state(1)
      fibonacci_state(0) = fibonacci_state(1)
      fibonacci_state(1) = n
      if (n % 2 == 0) fibonacci_state(2) = fibonacci_state(2) + n
    }
    s"${fibonacci_state(2)}"
  }
  println(s"Result = ${run()}")
}
