package helper

import org.scalatest.FunSuite

class MathHelperTest extends FunSuite {
  test("MathHelper.is_triangle_number") {
    assert(MathHelper.is_triangle_number(1))
    assert(MathHelper.is_triangle_number(3))
    assert(MathHelper.is_triangle_number(6))
    assert(MathHelper.is_triangle_number(10))
    assert(MathHelper.is_triangle_number(15))
    assert(!MathHelper.is_triangle_number(2))
    assert(!MathHelper.is_triangle_number(5))
    assert(!MathHelper.is_triangle_number(16))
  }

  test("MathHelper.is_pentagonal_number") {
    assert(MathHelper.is_pentagonal_number(22))
    assert(MathHelper.is_pentagonal_number(145))
    assert(!MathHelper.is_pentagonal_number(144))
    assert(!MathHelper.is_pentagonal_number(23))
    assert(!MathHelper.is_pentagonal_number(26))
  }

  test("MathHelper.is_hexagonal_number") {
    assert(MathHelper.is_hexagonal_number(1))
    assert(MathHelper.is_hexagonal_number(6))
    assert(MathHelper.is_hexagonal_number(15))
    assert(MathHelper.is_hexagonal_number(28))
    assert(MathHelper.is_hexagonal_number(45))
    assert(!MathHelper.is_hexagonal_number(2))
    assert(!MathHelper.is_hexagonal_number(5))
    assert(!MathHelper.is_hexagonal_number(17))
    assert(!MathHelper.is_hexagonal_number(30))
    assert(!MathHelper.is_hexagonal_number(46))
  }

  test("MathHelper.get_hexagonal_number") {
    assert(MathHelper.get_hexagonal_number(1) == 1)
    assert(MathHelper.get_hexagonal_number(2) == 6)
    assert(MathHelper.get_hexagonal_number(3) == 15)
    assert(MathHelper.get_hexagonal_number(4) == 28)
    assert(MathHelper.get_hexagonal_number(5) == 45)
  }

  test("MathHelper.get_pentagonal_number") {
    assert(MathHelper.get_pentagonal_number(1) == 1)
    assert(MathHelper.get_pentagonal_number(2) == 5)
    assert(MathHelper.get_pentagonal_number(3) == 12)
    assert(MathHelper.get_pentagonal_number(4) == 22)
    assert(MathHelper.get_pentagonal_number(5) == 35)
  }

  test("MathHelper.is_circular_prime") {
    assert(MathHelper.is_circular_prime(73))
    assert(MathHelper.is_circular_prime(71))
    assert(!MathHelper.is_circular_prime(23))
    assert(!MathHelper.is_circular_prime(2063))
  }

  test("MathHelper.is_right_truncatable_prime") {
    assert(MathHelper.is_right_truncatable_prime(23333))
    assert(MathHelper.is_right_truncatable_prime(797))
    assert(!MathHelper.is_right_truncatable_prime(911))
    assert(!MathHelper.is_right_truncatable_prime(919))
  }

  test("MathHelper.is_left_truncatable_prime") {
    assert(MathHelper.is_left_truncatable_prime(594397))
    assert(MathHelper.is_left_truncatable_prime(6397))
    assert(MathHelper.is_left_truncatable_prime(4397))
    assert(MathHelper.is_left_truncatable_prime(13313))
    assert(MathHelper.is_left_truncatable_prime(3313))
    assert(!MathHelper.is_left_truncatable_prime(191))
    assert(!MathHelper.is_left_truncatable_prime(491))
  }

  test("MathHelper.is_truncatable_prime") {
    assert(MathHelper.is_truncatable_prime(313))
    assert(MathHelper.is_truncatable_prime(373))
    assert(!MathHelper.is_truncatable_prime(577))
    assert(!MathHelper.is_truncatable_prime(773))
  }

  test("MathHelper.is_abundant_number") {
    assert(MathHelper.is_abundant_number(12))
    assert(MathHelper.is_abundant_number(18))
    assert(!MathHelper.is_abundant_number(6))
  }

  test("MathHelper.is_perfect_number") {
    assert(!MathHelper.is_perfect_number(12))
    assert(!MathHelper.is_perfect_number(18))
    assert(MathHelper.is_perfect_number(6))
  }

  test("MathHelper.is_deficient_number") {
    assert(MathHelper.is_deficient_number(11))
    assert(MathHelper.is_deficient_number(9))
    assert(!MathHelper.is_deficient_number(6))
  }

  test("MathHelper.is_palindrome") {
    assert(MathHelper.is_palindrome(1))
    assert(MathHelper.is_palindrome(11))
    assert(!MathHelper.is_palindrome(112))
    assert(MathHelper.is_palindrome(121))
    assert(MathHelper.is_palindrome(4312134))
    assert(!MathHelper.is_palindrome(4312124))
  }

  test("MathHelper.is_pythagorean") {
    assert(!MathHelper.is_pythagorean(1, 1, 1))
    assert(MathHelper.is_pythagorean(4, 3, 5))
    assert(MathHelper.is_pythagorean(9, 40, 41))
    assert(!MathHelper.is_pythagorean(2, 2, 9))
  }

  test("MathHelper.is_prime") {
    assert(!MathHelper.is_prime(1))
    assert(MathHelper.is_prime(2))
    assert(MathHelper.is_prime(3))
    assert(!MathHelper.is_prime(4))
    assert(MathHelper.is_prime(14741))
    assert(!MathHelper.is_prime(14743))
  }

  test("MathHelper.get_primes_bellow") {
    val primes = Array[Int](2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
    val answers = MathHelper.get_primes_bellow(100)
    assert(answers.count(_ == true) == primes.length)
    for (prime <- primes) assert(answers(prime - 1))
  }

  test("MathHelper.get_divisors") {
    val divisors_1 = Array[Int](1, 2, 3, 4, 6, 12)
    val answers_1 = MathHelper.get_divisors(12)
    assert(answers_1.length == divisors_1.length)
    for (divisor <- divisors_1) assert(answers_1.contains(divisor))
    val divisors_2 = Array[Int](1, 14741)
    val answers_2 = MathHelper.get_divisors(14741)
    assert(answers_2.length == divisors_2.length)
    for (divisor <- divisors_2) assert(answers_2.contains(divisor))
  }

  test("MathHelper.get_triangle_number") {
    assert(MathHelper.get_triangle_number(1) == 1)
    assert(MathHelper.get_triangle_number(2) == 3)
    assert(MathHelper.get_triangle_number(3) == 6)
    assert(MathHelper.get_triangle_number(4) == 10)
    assert(MathHelper.get_triangle_number(5) == 15)
    assert(MathHelper.get_triangle_number(6) == 21)
    assert(MathHelper.get_triangle_number(7) == 28)
  }

  test("MathHelper.get_collatz_sequence") {
    val collatz = Array[Int](11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1)
    val answers = MathHelper.get_collatz_sequence(11)
    assert(collatz.deep == answers.deep)
  }

  test("MathHelper.get_all_permutations") {
    val permutations = Array[String]("012", "021", "102", "120", "201", "210")
    val answers = MathHelper.get_all_permutations("012")
    assert(answers.length == permutations.length)
    for (permutation <- permutations) assert(answers.contains(permutation))
  }

  test("MathHelper.get_common_divisors") {
    val divisors = Array[Int](1, 2, 4)
    val answers = MathHelper.get_common_divisors(12, 4)
    assert(answers.length == divisors.length)
    for (divisor <- divisors) assert(answers.contains(divisor))
  }

  test("MathHelper.get_recurring_cycle") {
    assert(MathHelper.get_recurring_cycle("1", "3") == "3")
    assert(MathHelper.get_recurring_cycle("2", "3") == "6")
    assert(MathHelper.get_recurring_cycle("1", "7") == "142857")
  }

  test("MathHelper.convert_base_from_base_10") {
    assert(MathHelper.convert_base_from_base_10("4", "01") == "100")
    assert(MathHelper.convert_base_from_base_10("4", "ab") == "baa")
    assert(MathHelper.convert_base_from_base_10("10", "01") == "1010")
    assert(MathHelper.convert_base_from_base_10("424242", "01") == "1100111100100110010")
  }
}
