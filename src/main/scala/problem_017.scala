object problem_017 extends App {
  def run():String = {
    val digits = Array[Long](
      "one".length, "two".length, "three".length, "four".length, "five".length,
      "six".length, "seven".length, "eight".length, "nine".length)
    val numbers_10_to_19 = Array[Long](
      "ten".length, "eleven".length, "twelve".length, "thirteen".length,
      "fourteen".length, "fifteen".length, "sixteen".length, "seventeen".length,
      "eighteen".length, "nineteen".length
    )
    val decades = Array[Long](
      "twenty".length, "thirty".length, "forty".length, "fifty".length,
      "sixty".length, "seventy".length, "eighty".length, "ninety".length
    )
    val hundred = "hundred".length
    val and = "and".length
    val one_thousand = "onethousand".length

    val digits_sum = digits.sum
    val numbers_10_to_19_sum = numbers_10_to_19.sum
    val decade_sum = decades.map(decade => 10 * decade + digits_sum).sum
    val hundred_sum = digits.map{digit => (digit + hundred) * 100 + and * 99 + decade_sum + numbers_10_to_19_sum + digits_sum}.sum
    val result = digits_sum + numbers_10_to_19_sum + decade_sum + hundred_sum + one_thousand

    s"$result"
  }
  println(s"Result = ${run()}")
}
