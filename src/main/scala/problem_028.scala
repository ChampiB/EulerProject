object problem_028 extends App {
  def run():String = {
    var result = 1
    var state = (3, 5, 7, 9)
    for (i <- 4 to 1000 by 2) {
      result += state._1 + state._2 + state._3 + state._4
      state = (state._4 + i, state._4 + 2 * i, state._4 + 3 * i, state._4 + 4 * i)
    }
    result += state._1 + state._2 + state._3 + state._4
    s"$result"
  }
  println(s"Result = ${run()}")
}
