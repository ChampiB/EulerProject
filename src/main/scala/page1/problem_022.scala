package page1

import scala.io.Source._

object problem_022 extends App {
  def run():String = {
    val names = fromFile("./resource/problem_022.txt").getLines.flatMap{_.split(",")}.toArray
    val result = names
      .sorted
      .map{name => name.map{c => if (c == '"') 0 else c - 'A' + 1}.sum}
      .zipWithIndex
      .map{case(a, i) => a * (i + 1)}
    s"${result.sum}"
  }
  println(s"Result = ${run()}")
}
