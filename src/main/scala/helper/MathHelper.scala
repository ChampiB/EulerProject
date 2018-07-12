package helper

object MathHelper {
  def is_prime(n:Long):Boolean = ! ((2L until n) exists (n % _ == 0L))
}
