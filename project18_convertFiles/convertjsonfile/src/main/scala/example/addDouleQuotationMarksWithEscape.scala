package example

object Hello extends  App {

  import scala.io.Source

  val filename = "input.json"
  for (line <- Source.fromFile(filename).getLines) {
    for (c <- line) {
      if (c == '\"') {
        print("\\\"")
      } else {
        print(c)
      }
    }
  }
}




