# scala

## 1 how to initialize a scala project  
http://www.scala-sbt.org/0.13/docs/Hello.html


## 2 how to run it  
1) $> cd project1/project2/project3  
2) $> sbt  
3) $> run  


## x scala basics  
1) object  
In Scala, we cannot have static members. Instead, Scala has singleton objects. A singleton is a class that can have only one instance, i.e., Object. You create singleton using the keyword object instead of class keyword.  
```scala
object Demo {
   def main(args: Array[String]) {
      val point = new Point(10, 20)
      printPoint

      def printPoint{
         println ("Point x location : " + point.x);
         println ("Point y location : " + point.y);
      }
   }
}
```

2) Unit  
The Unit type is used to define a function that doesn't return data. It is similiar to the void keyword in Java.

```scala
def main(args: Array[String]) : Unit = { 
} 
```
The Unit literal is an empty pair of parentheses, ().


3) Equality of Objects  
In Scala the == and != methods (or operators if you will, but in Scala they are actually methods) check for value equality as opposed to Java or C# where they check for reference equality. Both the == and the != methods are defined as final in the Any type. They both use the equals method which is also defined, but not as final, in Any. In other words, for the == and != methods to work as expected for our custom types we need to override the equals method to ensure that it compares the relevant values.

For instance, let’s say that we have a Person class with a single field named name. Then two instances of that class with the same name should equal each other when the equals method or the == method is used, but as default they wont.
```scala
class Person(val name: String)

var person1 = new Person("John")
var person2 = new Person("John")
person1 == person2 //Should be true but is false
```

4) trait  
Traits are used to share interfaces and fields between classes. They are similar to Java 8's interfaces. Classes and objects can extend traits but traits cannot be instantiated and therefore have no parameters.   
```scala
trait Equal {
   def isEqual(x: Any): Boolean
   def isNotEqual(x: Any): Boolean = !isEqual(x)
}

class Point(xc: Int, yc: Int) extends Equal {
   var x: Int = xc
   var y: Int = yc
   
   def isEqual(obj: Any) = obj.isInstanceOf[Point] && obj.asInstanceOf[Point].x == y
}

object Demo {
   def main(args: Array[String]) {
      val p1 = new Point(2, 3)
      val p2 = new Point(2, 4)
      val p3 = new Point(3, 3)

      println(p1.isNotEqual(p2))
      println(p1.isNotEqual(p3))
      println(p1.isNotEqual(2))
   }
}
```


