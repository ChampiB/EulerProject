object problem_005 extends App {
  def modulo(i:Int, numbers:Range.Inclusive):Int = {
    var res = 0
    for (n <- numbers)
      if (i % n != 0)
        res = i % n
    res
  }
  var i = 1
  while (modulo(i, 1 to 20) != 0)
    i = i + 1
  println(s"Result = $i")
}
