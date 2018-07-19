package helper


object MathHelper {
  def is_palindrome(n:Long):Boolean = n.toString == n.toString.reverse
  def is_pythagorean(a:Long, b:Long, c:Long):Boolean = Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)
  def is_prime(n:Long):Boolean = {
    if (n == 2)
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
}
