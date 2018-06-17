package example

object Hello extends  App {

  val s1_correctOne = "<wsse:UsernameToken><wsse:Username>CLUEiIxBuPm8</wsse:Username><wsse:Password>12LILBErnKMW</wsse:Password></wsse:UsernameToken>"
  val s2_wrongOne   = "<wsse:UsernameToken><wsse:Username>CLUEiIxBuPm8</wsse:Username><wsse:Password>12LILBErnKMW</wsse:Password></wsse:UsernameToken>"
  val s3_wrongOne   = "<wsse:UsernameToken><wsse:Username>CLUEiIxBuPm8</wsse:Username><wsse:Password>12LILBErnKMW </wsse:Password></wsse:UsernameToken>"

  s1_correctOne.foreach(
    c => {
      print(c.toInt)
      print(" ")
    }
  )
  println()
  println()
  s2_wrongOne.foreach(
    c => {
      print(c.toInt)
      print(" ")
    }
  )
  println()
  println()
  for (i)

}




