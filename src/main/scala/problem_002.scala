object problem_002 extends App {
  val fibonacci_state = Array[Long](1, 2, 3) // (n-2, n-1, sum)
  while (fibonacci_state(0) + fibonacci_state(1) < 4000000) {
    val n = fibonacci_state(0) + fibonacci_state(1)
    fibonacci_state(0) = fibonacci_state(1)
    fibonacci_state(1) = n
    fibonacci_state(2) = fibonacci_state(2) + n
  }
  println(s"Result = ${fibonacci_state(2)}")
}
