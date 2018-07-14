object problem_006 extends App {
  def square_of_the_sum(numbers:Range.Inclusive):Long = {
    val res = for (n <- numbers) yield n.toDouble
    Math.pow(res.sum, 2).toLong
  }
  def sum_of_the_square(numbers:Range.Inclusive):Long = {
    val res = for (n <- numbers) yield Math.pow(n.toDouble, 2)
    res.sum.toLong
  }
  println(s"Result = ${square_of_the_sum(1 to 100) - sum_of_the_square(1 to 100)}")
}
