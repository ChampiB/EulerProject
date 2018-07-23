import helper.InfiniteNumbersHelper

object problem_020 extends App {
  val result = InfiniteNumbersHelper.factorial("100")
  println(s"Result = ${result.map(_ - '0').sum}")
}
