package page1

object problem_015 extends App {
  def count_number_of_route(x_start:Long, y_start:Long, width:Long, height:Long):Long = {
    var result = 0L
    if (x_start == width || y_start == height)
      result = result + 1
    else {
      if (x_start + 1 != width || y_start != height)
        result = result + count_number_of_route(x_start + 1, y_start, width, height)
      if (x_start != width || y_start + 1 != height)
        result = result + count_number_of_route(x_start, y_start + 1, width, height)
    }
    result
  }
  def run():String = {
    s"${count_number_of_route(0, 0, 20, 20)}"
  }
  println(s"Result = ${run()}")
}
