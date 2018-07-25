import helper.InfiniteNumbersHelper

object problem_040 extends App {
  def run():String = {
    var str = ""
    var i = "1"
    while (str.length < 1000000) {
      str = s"$str$i"
      i = InfiniteNumbersHelper.add(i, "1")
    }
    val result = (str(0)     .toLong - '0') *
                 (str(9)     .toLong - '0') *
                 (str(99)    .toLong - '0') *
                 (str(999)   .toLong - '0') *
                 (str(9999)  .toLong - '0') *
                 (str(99999) .toLong - '0') *
                 (str(999999).toLong - '0')
    s"$result"
  }
  println(s"Result = ${run()}")
}
