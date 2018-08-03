package helper


object MathHelper {
  def are_permutations(a:Array[String]):Boolean = {
    val array = for (i <- 0 until a.length - 1) yield {
      var tmp = a(i + 1)
      for (c <- a(i)) tmp = tmp.replaceFirst(s"$c", "")
      tmp.length == 0
    }
    !array.contains(false) && a.map(_.length == a(0).length).reduce(_ && _)
  }
  def is_composite_number(n:Long):Boolean = {
    (2L until n) exists (n % _ == 0L)
  }
  def is_triangle_number(n:Long):Boolean = {
    var i = 1
    var pi = get_triangle_number(i)
    while (pi < n) {
      i += 1
      pi = get_triangle_number(i)
    }
    pi == n
  }
  def is_pentagonal_number(n:Long):Boolean = {
    var i = 1
    var pi = get_pentagonal_number(i)
    while (pi < n) {
      i += 1
      pi = get_pentagonal_number(i)
    }
    pi == n
  }
  def is_hexagonal_number(n:Long):Boolean = {
    var i = 1
    var pi = get_hexagonal_number(i)
    while (pi < n) {
      i += 1
      pi = get_hexagonal_number(i)
    }
    pi == n
  }
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
    if (n <= 1)
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
  def get_common_divisors(n1:Int, n2:Int):Array[Int] = {
    val n1_divisors = get_divisors(n1)
    val n2_divisors = get_divisors(n2)
    n1_divisors.filter{n => n2_divisors contains n}.map(_.toInt)
  }
  def get_recurring_cycle(n:String, d:String, max_number_of_decimals:Long = 10000L):String = {
    val r = InfiniteNumbersHelper.div(n, d, max_number_of_decimals)
    val index = r.indexOf('.')
    if (index != -1) {
      val decimals = r.substring(index + 1, r.length)
      var result = ""
      for (i <- 1 to decimals.length / 2) {
        if (decimals.substring(decimals.length - i, decimals.length) == decimals.substring(decimals.length - i * 2, decimals.length - i) && result == "")
          result = decimals.substring(decimals.length - i, decimals.length)
      }
      if (result.length != 0) {
        val indexes = for (_ <- 0 to result.length) yield {
          result = s"${result.last}${result.dropRight(1)}"
          val index = decimals.indexOf(result)
          if (index != -1) index else decimals.length
        }
        decimals.substring(indexes.min, indexes.min + result.length)
      } else {
        result
      }
    } else {
      ""
    }
  }
  def get_triangle_number(i:Long):Long = {
    i * (i + 1) / 2
  }
  def get_pentagonal_number(i:Long):Long = {
    i * (3 * i - 1) / 2
  }
  def get_hexagonal_number(i:Long):Long = {
    i * (2 * i - 1)
  }
  def convert_base_from_base_10(n:String, base_to:String):String = {
    var result = ""
    var nn = n
    while (nn != "0") {
      val index_base_to = InfiniteNumbersHelper.mod(nn, base_to.length.toString)
      result = s"${base_to(index_base_to.toInt)}$result"
      nn = InfiniteNumbersHelper.div(nn, base_to.length.toString)
    }
    while (result.length != 1 && result(0) == base_to(0))
      result = result drop 1
    result
  }
}
