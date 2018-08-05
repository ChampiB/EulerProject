package page1

import helper.{InfiniteNumbersHelper, MathHelper}


object problem_043 extends App {
  def clear_zero(s:String):String = {
    if (s(0) == '0') s drop 1 else s
  }
  def check_division_property(n:String):Boolean = {
    InfiniteNumbersHelper.mod(clear_zero(n.substring(1,  4)),  "2") == "0" &&
    InfiniteNumbersHelper.mod(clear_zero(n.substring(2,  5)),  "3") == "0" &&
    InfiniteNumbersHelper.mod(clear_zero(n.substring(3,  6)),  "5") == "0" &&
    InfiniteNumbersHelper.mod(clear_zero(n.substring(4,  7)),  "7") == "0" &&
    InfiniteNumbersHelper.mod(clear_zero(n.substring(5,  8)), "11") == "0" &&
    InfiniteNumbersHelper.mod(clear_zero(n.substring(6,  9)), "13") == "0" &&
    InfiniteNumbersHelper.mod(clear_zero(n.substring(7, 10)), "17") == "0"
  }
  def run():String = {
    val permutations = MathHelper.get_all_permutations("0123456789")
    s"${permutations.filter(check_division_property).reduce(InfiniteNumbersHelper.add)}"
  }
  println(s"Result = ${run()}")
}
