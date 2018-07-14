package helper

object MathHelper {
  def is_prime(n:Long):Boolean = ! ((2L until n) exists (n % _ == 0L))
  def is_palindrome(n:Long):Boolean = n.toString == n.toString.reverse
  def is_pythagorean(a:Long, b:Long, c:Long):Boolean = Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)
}
