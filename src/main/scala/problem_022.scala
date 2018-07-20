import scala.io.Source._

object problem_022 extends App {
  val names = fromFile("./resource/problem_022.txt").getLines.flatMap{_.split(",")}.toArray
  val result = names
    .sorted
    .map{name => name.map{c => if (c == '"') 0 else c - 'A' + 1}.sum}
    .zipWithIndex
    .map{case(a, i) => a * (i + 1)}
  println(s"Result = ${result.sum}")
}
