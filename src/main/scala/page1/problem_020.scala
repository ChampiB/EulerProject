package page1

import helper.InfiniteNumbersHelper

object problem_020 extends App {
  def run():String = {
    val result = InfiniteNumbersHelper.factorial("100")
    s"${result.map(_ - '0').sum}"
  }
  println(s"Result = ${run()}")
}
