import scala.io.Source._

object problem_067 extends App {
  def run():String = {
    val pyramid = fromFile("./resource/problem_067.txt").getLines.map{_.split(" ").map{_.toInt}}.toArray
    def get_max_parent(parents:Array[Int], x:Int):Int = {
      if (x == 0)
        parents(x)
      else if (x == parents.length)
        parents(x - 1)
      else
        parents(x - 1) max parents(x)
    }
    var result = pyramid(0)
    for (y <- 1 until pyramid.length) {
      val values = for (x <- pyramid(y).indices) yield pyramid(y)(x) + get_max_parent(result, x)
      result = values.toArray
    }
    s"${result.max}"
  }
  println(s"Result = ${run()}")
}
