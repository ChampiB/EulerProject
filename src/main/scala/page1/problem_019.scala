package page1

object problem_019 extends App {
  def run():String = {
    val years = for (i <- 1900 until 2000) yield
      for (j <- Array(31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)) yield
        for (k <- 0 until (if (j != 0) j else if (i % 4 == 0) 29 else 28)) yield
          if (i != 1900 && k == 0) true else false
    val days = years.flatMap{a => a.flatMap{a => a}}
    val indexes = for (index <- 5 until days.length by 7) yield index
    val result = for (i <- indexes) yield if (days(i)) 1 else 0
    s"${result.sum}"
  }
  println(s"Result = ${run()}")
}
