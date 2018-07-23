import helper.MathHelper

object problem_033 extends App {
  var fractions = Array[(Int, Int)]()
  for (i <- 10 to 99) {
    for (j <- 10 to 99) {
      for (c <- i.toString) {
        val jj = j.toString.replace(c.toString, "")
        val ii = i.toString.replace(c.toString, "")
        if (
          ii.length == 1 && jj.length == 1 &&
            ii.toDouble / jj.toDouble == i.toDouble / j.toDouble &&
            i != j &&
            !(i.toString.charAt(1) == '0' && j.toString.charAt(1) == '0')
        ) {
          fractions ++= Array((jj.toInt, ii.toInt))
        }
      }
    }
  }
  fractions = fractions
    .map{case(n1, n2) => if (n1 < n2) (n1, n2) else (n2, n1)}
    .distinct
  val n = fractions.map(_._1).product
  val d = fractions.map(_._2).product
  val hcd = MathHelper.get_common_divisors(n, d).max
  println(s"Result = ${d / hcd}")
}
