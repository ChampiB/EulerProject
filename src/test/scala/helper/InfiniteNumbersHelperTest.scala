package helper

import org.scalatest.FunSuite

class InfiniteNumbersHelperTest extends FunSuite {
  test("InfiniteNumbersHelper.is_palindrome") {
    assert(InfiniteNumbersHelper.is_palindrome("585"))
    assert(!InfiniteNumbersHelper.is_palindrome("54"))
    assert(!InfiniteNumbersHelper.is_palindrome("ab"))
    assert(InfiniteNumbersHelper.is_palindrome("aba"))
    assert(InfiniteNumbersHelper.is_palindrome("10101"))
  }

  test("InfiniteNumbersHelper.is_equal") {
    assert(InfiniteNumbersHelper.is_equal("585", "585"))
    assert(!InfiniteNumbersHelper.is_equal("585", "584"))
    assert(!InfiniteNumbersHelper.is_equal("584", "585"))
  }

  test("InfiniteNumbersHelper.is_superior") {
    assert(!InfiniteNumbersHelper.is_superior("585", "585"))
    assert(InfiniteNumbersHelper.is_superior("585", "584"))
    assert(!InfiniteNumbersHelper.is_superior("584", "585"))
  }

  test("InfiniteNumbersHelper.is_superior_or_equal") {
    assert(InfiniteNumbersHelper.is_superior_or_equal("585", "585"))
    assert(InfiniteNumbersHelper.is_superior_or_equal("585", "584"))
    assert(!InfiniteNumbersHelper.is_superior_or_equal("584", "585"))
  }

  test("InfiniteNumbersHelper.is_inferior_or_equal") {
    assert(InfiniteNumbersHelper.is_inferior_or_equal("585", "585"))
    assert(!InfiniteNumbersHelper.is_inferior_or_equal("585", "584"))
    assert(InfiniteNumbersHelper.is_inferior_or_equal("584", "585"))
  }

  test("InfiniteNumbersHelper.is_inferior") {
    assert(!InfiniteNumbersHelper.is_inferior("585", "585"))
    assert(!InfiniteNumbersHelper.is_inferior("585", "584"))
    assert(InfiniteNumbersHelper.is_inferior("584", "585"))
  }

  test("InfiniteNumbersHelper.add") {
    assert(InfiniteNumbersHelper.add("999", "1") == "1000")
    assert(InfiniteNumbersHelper.add("1", "999") == "1000")
    assert(InfiniteNumbersHelper.add("22", "3") == "25")
    assert(InfiniteNumbersHelper.add("10000", "1") == "10001")
    assert(InfiniteNumbersHelper.add("1000000000000000000000000000000", "1") == "1000000000000000000000000000001")
  }

  test("InfiniteNumbersHelper.sub") {
    assert(InfiniteNumbersHelper.sub("999", "1") == "998")
    assert(InfiniteNumbersHelper.sub("1", "999") == "-998")
    assert(InfiniteNumbersHelper.sub("22", "3") == "19")
    assert(InfiniteNumbersHelper.sub("10000", "1") == "9999")
  }

  test("InfiniteNumbersHelper.div") {
    // Integer division
    assert(InfiniteNumbersHelper.div("2", "1") == "2")
    assert(InfiniteNumbersHelper.div("2", "2") == "1")
    assert(InfiniteNumbersHelper.div("3", "2") == "1")
    assert(InfiniteNumbersHelper.div("200", "2") == "100")
    assert(InfiniteNumbersHelper.div("41", "2") == "20")
    // Decimal division
    assert(InfiniteNumbersHelper.div("41", "2", 1) == "20.5")
    assert(InfiniteNumbersHelper.div("41", "2", 2) == "20.5")
    assert(InfiniteNumbersHelper.div("1", "3", 5) == "0.33333")
    assert(InfiniteNumbersHelper.div("4", "3", 5) == "1.33333")
  }

  test("InfiniteNumbersHelper.mul") {
    assert(InfiniteNumbersHelper.mul("0", "45") == "0")
    assert(InfiniteNumbersHelper.mul("2", "1") == "2")
    assert(InfiniteNumbersHelper.mul("2", "2") == "4")
    assert(InfiniteNumbersHelper.mul("3", "4") == "12")
    assert(InfiniteNumbersHelper.mul("200", "2") == "400")
    assert(InfiniteNumbersHelper.mul("45", "2") == "90")
    assert(InfiniteNumbersHelper.mul("2", "45") == "90")
  }

  test("InfiniteNumbersHelper.mod") {
    assert(InfiniteNumbersHelper.mod("2", "1") == "0")
    assert(InfiniteNumbersHelper.mod("2", "2") == "0")
    assert(InfiniteNumbersHelper.mod("1", "2") == "1")
    assert(InfiniteNumbersHelper.mod("3", "2") == "1")
    assert(InfiniteNumbersHelper.mod("3", "4") == "3")
    assert(InfiniteNumbersHelper.mod("200", "2") == "0")
    assert(InfiniteNumbersHelper.mod("45", "5") == "0")
    assert(InfiniteNumbersHelper.mod("2", "45") == "2")
    assert(InfiniteNumbersHelper.mod("92", "45") == "2")
  }

  test("InfiniteNumbersHelper.pow") {
    assert(InfiniteNumbersHelper.mul("0", "45") == "0")
    assert(InfiniteNumbersHelper.pow("2", "1") == "2")
    assert(InfiniteNumbersHelper.pow("2", "0") == "1")
    assert(InfiniteNumbersHelper.pow("1", "2") == "1")
    assert(InfiniteNumbersHelper.pow("3", "2") == "9")
    assert(InfiniteNumbersHelper.pow("200", "2") == "40000")
    assert(InfiniteNumbersHelper.pow("3", "12") == "531441")
  }

  test("InfiniteNumbersHelper.factorial") {
    assert(InfiniteNumbersHelper.factorial("0") == "1")
    assert(InfiniteNumbersHelper.factorial("1") == "1")
    assert(InfiniteNumbersHelper.factorial("2") == "2")
    assert(InfiniteNumbersHelper.factorial("3") == "6")
    assert(InfiniteNumbersHelper.factorial("100") == "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000")
  }
}
