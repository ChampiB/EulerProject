package page1

import helper.{InfiniteNumbersHelper, MathHelper}

object problem_038 extends App {
  def can_be_write_as_pandigital_multiples(permutation:String, base_size:Int):Boolean = {
    var result = false
    var tmp_permutation = permutation.substring(base_size, permutation.length)
    val base = permutation.substring(0, base_size)
    var j = 2
    do {
      val product = InfiniteNumbersHelper.mul(base, j.toString)
      if (tmp_permutation.length <= product.length && tmp_permutation.substring(0, product.length) == product) {
        tmp_permutation = tmp_permutation.drop(product.length)
        if (tmp_permutation.length == 0)
          result = true
      } else {
        tmp_permutation = ""
      }
      j += 1
    } while (tmp_permutation.length != 0)
    result
  }
  def run():String = {
    val permutations = MathHelper.get_all_permutations("123456789")
    var i = permutations.length - 1
    var result = ""
    while (i >= 0) {
      val permutation = permutations(i)
      for (n <- 1 to permutation.length / 2) {
        if (can_be_write_as_pandigital_multiples(permutation, n)) {
          result = permutation
          i = 0
        }
      }
      i -= 1
    }
    result
  }
  println(s"Result = ${run()}")
}
