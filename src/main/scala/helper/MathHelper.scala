package helper


object MathHelper {
  def is_circular_prime(n:Long):Boolean = {
    var n_string = n.toString
    val are_primes = for (_ <- 1 to n_string.length) yield {
      n_string = s"${n_string.drop(1)}${n_string(0)}"
      is_prime(n_string.toLong)
    }
    !are_primes.contains(false)
  }
  def is_right_truncatable_prime(n:Long):Boolean = {
    var n_string = n.toString
    val are_primes = for (_ <- 1 to n_string.length) yield {
      val prime = is_prime(n_string.toLong)
      n_string = n_string.dropRight(1)
      prime
    }
    !are_primes.contains(false)
  }
  def is_left_truncatable_prime(n:Long):Boolean = {
    var n_string = n.toString
    val are_primes = for (_ <- 1 to n_string.length) yield {
      val prime = is_prime(n_string.toLong)
      n_string = n_string.drop(1)
      prime
    }
    !are_primes.contains(false)
  }
  def is_truncatable_prime(n:Long):Boolean = {
    is_right_truncatable_prime(n) && is_left_truncatable_prime(n)
  }
  def is_abundant_number(n:Long):Boolean = n < get_divisors(n).sum - n
  def is_perfect_number(n:Long):Boolean = n == get_divisors(n).sum - n
  def is_deficient_number(n:Long):Boolean = n > get_divisors(n).sum - n
  def is_palindrome(n:Long):Boolean = n.toString == n.toString.reverse
  def is_pythagorean(a:Long, b:Long, c:Long):Boolean = Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)
  def is_prime(n:Long):Boolean = {
    if (n == 1)
      false
    else if (n == 2)
      true
    else if (n % 2 == 0)
      false
    else
      ! ((3L to Math.sqrt(n).toLong by 2) exists (n % _ == 0L))
  }
  def get_primes_bellow(n:Int):Array[Boolean] = {
    val are_primes = for (i <- 1 to n) yield if (i == 1) false else true
    val array_are_primes = are_primes.toArray
    for (i <- 1 to n) {
      if (array_are_primes(i - 1) && is_prime(i)) {
        for (e <- i * 2 to n by i) array_are_primes(e - 1) = false
      } else {
        array_are_primes(i - 1) = false
      }
    }
    array_are_primes
  }
  def get_divisors(n:Long):Array[Long] = {
    var divisors = Array[Long]()
    for (i <- 1L to Math.sqrt(n).toLong) {
      if (n % i == 0L) {
        if (n / i != i)
          divisors = divisors ++ Array(i, n / i)
        else
          divisors = divisors ++ Array(i)
      }
    }
    divisors
  }
  def get_triangle_number(index:Long):Long = {
    val values = for (i <- 1L to index) yield i
    values.sum
  }
  def infinite_add(n1:String, n2:String):String = {
    var result = ""
    var r = 0L
    val rn1 = n1.reverse
    val rn2 = n2.reverse
    for (i <- 0 until (rn1.length max rn2.length)) {
      val d1 = if (i < rn1.length) rn1.charAt(i).toLong - '0' else 0L
      val d2 = if (i < rn2.length) rn2.charAt(i).toLong - '0' else 0L
      result = s"${(d1 + d2 + r) % 10L}$result"
      r = (d1 + d2 + r) / 10L
    }
    if (r != 0)
      s"$r$result"
    else
      result
  }
  def infinite_mul(n1:String, n2:String):String = {
    var result = "0"
    val rn1 = n1.reverse
    val rn2 = n2.reverse
    for (i <- 0 until rn1.length) {
      var tmp_result = ""
      var r = 0L
      val d1 = if (i < rn1.length) rn1.charAt(i).toLong - '0' else 0L
      for (j <- 0 until rn2.length) {
        val d2 = if (j < rn2.length) rn2.charAt(j).toLong - '0' else 0L
        tmp_result = s"${(d1 * d2 + r) % 10L}$tmp_result"
        r = (d1 * d2 + r) / 10L
      }
      if (r != 0) tmp_result = s"$r$tmp_result"
      for (_ <- 0 until i) tmp_result = s"${tmp_result}0"
      result = infinite_add(result, tmp_result)
    }
    result
  }
  def infinite_pow(n:String, power:String):String = {
    if (power == "0") {
      "1"
    } else {
      var result = n
      var i = "1"
      while (i != power) {
        result = infinite_mul(result, n)
        i = infinite_add(i, "1")
      }
      result
    }
  }
  def infinite_factorial(n:String):String = {
    if (n == "0") {
      "1"
    } else {
      var result = "1"
      var i = "1"
      while (i != n) {
        result = infinite_mul(result, i)
        i = infinite_add(i, "1")
      }
      result
    }
  }
  def get_collatz_sequence(start:Long):Array[Long] = {
    var result = Array[Long](start)
    var n = start
    while (n != 1) {
      n = if (n % 2 == 0)
        n / 2
      else
        3 * n + 1
      result = result ++ Array(n)
    }
    result
  }
  def get_all_permutations(sequence:String):Array[String] = {
    if (sequence.length == 1) {
      Array(sequence(0).toString)
    } else {
      val permutations = for (i <- sequence.indices) yield {
        val begin = if (i == 0) "" else sequence.take(i)
        val end = if (i == sequence.length - 1) "" else sequence.takeRight(sequence.length - i - 1)
        get_all_permutations(s"$begin$end").map{p => s"${sequence(i)}$p"}
      }
      permutations.flatten.toArray
    }
  }
}
