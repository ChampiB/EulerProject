package page2

object problem_052 extends App {
  def have_the_same_digits(numbers: IndexedSeq[Long]):Boolean = {
    val numbers_string = numbers.map(_.toString.sorted).toArray
    val same = for (number_string <- numbers_string) yield numbers_string(0) == number_string
    !same.contains(false)
  }
  def run():String = {
    var i = 1L
    while (!have_the_same_digits(for (n <- 1L to 6L) yield i * n)) {
      println(i)
      i += 1
    }
    i.toString
  }
  println(s"Result = ${run()}")
}
