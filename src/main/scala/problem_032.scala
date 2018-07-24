import helper.MathHelper

object problem_032 extends App {
  def run():String = {
    val permutations = MathHelper.get_all_permutations("123456789")
    var valid_answers = Array[(Long, Long)]()
    for (p <- permutations) {
      val l = p.length
      for (i <- 1 to p.length - 2) {
        for (j <- i + 1 until p.length) {
          val n1 = p.slice(0, i).toLong
          val n2 = p.slice(i, j).toLong
          val n3 = p.slice(j, l).toLong
          if (n1 * n2 == n3) valid_answers ++= Array[(Long, Long)]((n1, n2))
        }
      }
    }
    val result = valid_answers
      .map{case(n1, n2) => if (n1 < n2) (n1, n2) else (n2, n1)}
      .map{case(n1, n2) => n1 * n2}
      .distinct
      .sum
    s"$result"
  }
  println(s"Result = ${run()}")
}
