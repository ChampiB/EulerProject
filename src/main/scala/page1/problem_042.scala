package page1

import helper.MathHelper

import scala.io.Source.fromFile

object problem_042 extends App {
  def run():String = {
    val words = fromFile("./resource/problem_042.txt")
      .getLines
      .flatMap{_.split(",")}
      .toArray
      .map{_ drop 1 dropRight 1}
      .map{_.map{c => c - 'A' + 1}.sum.toLong}
    val max = words.max
    var triangle_numbers = Array[Long]()
    var i = 1
    var n = 0L
    do {
      n = MathHelper.get_triangle_number(i)
      triangle_numbers ++= Array(n)
      i += 1
    } while (n <= max)
    s"${words.count(triangle_numbers contains _)}"
  }
  println(s"Result = ${run()}")
}
