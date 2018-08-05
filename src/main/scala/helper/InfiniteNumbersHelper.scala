package helper

/*
** TODO: Handle negative numbers
** TODO: Handle decimal numbers
*/
object InfiniteNumbersHelper {
  def is_palindrome(n:String):Boolean = {
    val result = for (i <- 0 to n.length / 2) yield n(i) == n(n.length - i - 1)
    !result.contains(false)
  }
  def is_equal(n1:String, n2:String):Boolean = {
    n1 == n2
  }
  def is_superior(n1:String, n2:String):Boolean = {
    if (n1.length > n2.length) {
      true
    } else if (n1.length < n2.length) {
      false
    } else {
      var found = false
      var result = false
      var i = 0
      while (!found && i < n1.length) {
        if (n1(i) != n2(i)) {
          found = true
          result = if (n1(i) > n2(i)) true else false
        }
        i += 1
      }
      result
    }
  }
  def is_superior_or_equal(n1:String, n2:String):Boolean = {
    !is_inferior(n1, n2)
  }
  def is_inferior_or_equal(n1:String, n2:String):Boolean = {
    !is_superior(n1, n2)
  }
  def is_inferior(n1:String, n2:String):Boolean = {
    if (n1.length > n2.length) {
      false
    } else if (n1.length < n2.length) {
      true
    } else {
      var found = false
      var result = false
      var i = 0
      while (!found && i < n1.length) {
        if (n1(i) != n2(i)) {
          found = true
          result = if (n1(i) > n2(i)) false else true
        }
        i += 1
      }
      result
    }
  }
  def add(n1:String, n2:String):String = {
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
  def sub(n1:String, n2:String):String = {
    if (is_equal(n1, n2)) {
      "0"
    } else {
      var _n1 = n1
      var _n2 = n2
      val negative = if (is_inferior(n1, n2)) { _n1 = n2; _n2 = n1; true } else { false }
      val rn1 = _n1.reverse
      val rn2 = _n2.reverse
      var r = 0
      var result = ""
      for (i <- 0 until Math.max(rn1.length, rn2.length)) {
        val d1 = if (i < rn1.length) rn1.charAt(i).toLong - '0' else 0
        val d2 = if (i < rn2.length) rn2.charAt(i).toLong - '0' else 0
        var char_res = d1 - (d2 + r)
        r = if (char_res < 0) { char_res = 10 + char_res; 1 } else { 0 }
        result = s"$char_res$result"
      }
      while (result.length > 1 && result.charAt(0) == '0')
        result = result drop 1
      if (negative) s"-$result" else result
    }
  }
  def div(n1:String, n2:String):String = {
    if (is_equal(n2, "0"))
      throw new Exception("[Error]: Can not divide by zero.")
    if (is_inferior(n1, n2)) {
      "0"
    } else {
      var result = ""
      var r = ""
      var i = 0
      while (i < n1.length) {
        r = if (r != "0") s"$r${n1(i)}" else s"${n1(i)}"
        if (is_inferior(r, n2)) {
          result = s"${result}0"
        } else {
          var j = "1"
          while (is_superior_or_equal(r, mul(n2, j)))
            j = add(j, "1")
          j = sub(j, "1")
          r = sub(r, mul(n2, j))
          result = s"$result$j"
        }
        i += 1
      }
      while (result.length != 1 && result(0) == '0')
        result = result drop 1
      result
    }
  }
  def div(n1:String, n2:String, max_number_of_decimals:Long):String = {
    // Basic check
    if (is_equal(n2, "0"))
      throw new Exception("[Error]: Can not divide by zero.")
    // Integer part
    var result = ""
    var r = ""
    var i = 0
    while (i < n1.length) {
      r = if (r != "0") s"$r${n1(i)}" else s"${n1(i)}"
      if (is_inferior(r, n2)) {
        result = s"${result}0"
      } else {
        var j = "1"
        while (is_superior_or_equal(r, mul(n2, j)))
          j = add(j, "1")
        j = sub(j, "1")
        r = sub(r, mul(n2, j))
        result = s"$result$j"
      }
      i += 1
    }
    while (result.length != 1 && result(0) == '0')
      result = result drop 1
    // Decimal part
    if (r != "0" && max_number_of_decimals > 0) {
      result = s"$result."
      i = 0
      while (i < max_number_of_decimals) {
        r = if (r == "0") "0" else s"${r}0"
        if (is_inferior(r, n2)) {
          result = s"${result}0"
        } else {
          var j = "1"
          while (is_superior_or_equal(r, mul(n2, j)))
            j = add(j, "1")
          j = sub(j, "1")
          r = sub(r, mul(n2, j))
          result = s"$result$j"
        }
        i += 1
      }
      while (result(result.length - 1) == '0')
        result = result dropRight 1
    }
    result
  }
  def mul(n1:String, n2:String):String = {
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
      result = add(result, tmp_result)
    }
    while(result.length != 1 && result(0) == '0')
      result = result drop 1
    result
  }
  def mod(n1:String, n2:String):String = {
    sub(n1, mul(div(n1, n2), n2))
  }
  def pow(n:String, power:String):String = {
    if (power == "0") {
      "1"
    } else {
      var result = n
      var i = "1"
      while (i != power) {
        result = mul(result, n)
        i = add(i, "1")
      }
      result
    }
  }
  def factorial(n:String):String = {
    if (n == "0") {
      "1"
    } else {
      var result = "1"
      var i = "0"
      while (i != n) {
        i = add(i, "1")
        result = mul(result, i)
      }
      result
    }
  }
  def among(k:String, n:String, factorials:Array[String] = null):String = {
    if (factorials == null)
      div(factorial(n), mul(factorial(k), factorial(sub(n, k))))
    else
      div(factorials(n.toInt), mul(factorials(k.toInt), factorials(sub(n, k).toInt)))
  }
}
