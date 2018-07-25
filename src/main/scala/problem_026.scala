import helper.MathHelper

object problem_026 extends App {
  def run():String = {
    var longest_recurring_cycle_size = 0
    var result = 0
    for (i <- 2 until 1000) {
      val recurring_cycle = MathHelper.get_recurring_cycle("1", i.toString)
      if (recurring_cycle.length > longest_recurring_cycle_size) {
        longest_recurring_cycle_size = recurring_cycle.length
        result = i
      }
    }
    s"$result"
  }
  println(s"Result = ${run()}")
}
