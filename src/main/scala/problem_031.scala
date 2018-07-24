object problem_031 extends App {
  def run():String = {
    var result = 0L
    for (i1 <- 0 to 200 by 1)
      for (i2 <- 0 to 200 by 2)
        for (i3 <- 0 to 200 by 5)
          for (i4 <- 0 to 200 by 10)
            for (i5 <- 0 to 200 by 20)
              for (i6 <- 0 to 200 by 50)
                for (i7 <- 0 to 200 by 100)
                  for (i8 <- 0 to 200 by 200)
                    if (i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 == 200)
                      result += 1L
    s"$result"
  }
  println(s"Result = ${run()}")
}
