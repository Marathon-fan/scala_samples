

class Foo(val name: String, val age: Int, val sex: Symbol)

object Foo {
      def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)
}


val fooList = Foo("Hugh Jass", 25, 'male) ::
              Foo("Biggus Dickus", 43, 'male) ::
              Foo("Incontinentia Buttocks", 37, 'female) ::
              Nil

val stringList = fooList.foldLeft(List[String]()) { (z, f) =>
  val title = f.sex match {
    case 'male => "Mr."
    case 'female => "Ms."
  }
  z :+ s"$title ${f.name}, ${f.age}"
}

println(stringList)

// scala symbol :+
:+ is a method on whatever type is returned by someVariable.next().
Presumably it's scala.Array.:+
A copy of this array with an element appended.


// stringList(0)
// Mr. Hugh Jass, 25

// stringList(2)
// Ms. Incontinentia Buttocks, 37

// The primary difference is the order in which the fold operation iterates through the collection in question. 
// foldLeft starts on the left side—the first item—and iterates to the right; 
// foldRight starts on the right side—the last item—and iterates to the left. fold goes in no particular order.


// scala Symbol
// This class provides a simple way to get unique objects for equal strings. Since symbols are interned, 
// they can be compared using reference equality. Instances of Symbol can be created easily with Scala's built-in quote mechanism.


