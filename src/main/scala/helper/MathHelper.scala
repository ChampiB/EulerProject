package helper

object MathHelper {
  def is_prime(n:Long):Boolean = {
    if (n == 2)
      true
    else if (n % 2 == 0)
      false
    else
      ! ((3L to Math.sqrt(n).toLong by 2) exists (n % _ == 0L))
  }
  def is_palindrome(n:Long):Boolean = n.toString == n.toString.reverse
  def is_pythagorean(a:Long, b:Long, c:Long):Boolean = Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)
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
}
