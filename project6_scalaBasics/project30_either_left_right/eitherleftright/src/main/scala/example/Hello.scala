package example

object Hello extends   App {
  println("example")

  def divideXByY(x:Int, y:Int):Either[String, Int] = {
    if (y == 0) Left("Dude, can't divide by 0")
    else Right(x / y)
  }

  // some different ways to use Either, Left and Right
  println( divideXByY(1, 0))
  println( divideXByY(1,1))
  divideXByY(1, 0) match {
    case Left(s) => println("Left has been returned:Left:" + s )
    case Right(i) => println("Right has been returned:Right:" + i)
  }
  divideXByY(1, 1) match {
    case Left(s) => println("Left has been returned:Left:" + s )
    case Right(i) => println("Right has been returned:Right:" + i)
  }
}

