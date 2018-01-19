# scala

## 1 how to run these projects  
1) $> cd project1/project2/project3  
2) $> sbt  
3) $> run  

## 2 project 1-introduction  
this project demonstrates how to use async(Futures and Scala Async)  

## 3 project 2-introduction    
this project demonstrates how to MacWire to make DI(dependency injection)  

## 4 project 3-introduction    
this project demonstrates how to use Spray api 


## 5 how to initialize a scala project  
http://www.scala-sbt.org/0.13/docs/Hello.html

$ sbt new sbt/scala-seed.g8  
name [My Something Project]: hello  
...  
$ cd hello  
$ sbt  
...  
> run  

## 6 scala basics  

### 1) object  
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

### 2) Unit  
The Unit type is used to define a function that doesn't return data. It is similiar to the void keyword in Java.

```scala
def main(args: Array[String]) : Unit = { 
} 
```
The Unit literal is an empty pair of parentheses, ().


### 3) Equality of Objects  
In Scala the == and != methods (or operators if you will, but in Scala they are actually methods) check for value equality as opposed to Java or C# where they check for reference equality. Both the == and the != methods are defined as final in the Any type. They both use the equals method which is also defined, but not as final, in Any. In other words, for the == and != methods to work as expected for our custom types we need to override the equals method to ensure that it compares the relevant values.

For instance, let’s say that we have a Person class with a single field named name. Then two instances of that class with the same name should equal each other when the equals method or the == method is used, but as default they wont.
```scala
class Person(val name: String)

var person1 = new Person("John")
var person2 = new Person("John")
person1 == person2 //Should be true but is false
```

### 4) trait  
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


### 5) with key word; Mixins are traits which are used to compose a class.  
```scala
abstract class A {
  val message: String
}
class B extends A {
  val message = "I'm an instance of class B"
}
trait C extends A {
  def loudMessage = message.toUpperCase()
}
class D extends B with C

val d = new D
println(d.message)  // I'm an instance of class B
println(d.loudMessage)  // I'M AN INSTANCE OF CLASS B
```
Class D has a superclass B and a mixin C. Classes can only have one superclass but many mixins (using the keywords extends and with respectively). The mixins and the superclass may have the same supertype.  


```scala  
trait Swim {
  def swim = println("Swimming!")
}
class Person
val p1 = new Person  // A Person who can't swim
val p2 = new Person with Swim  // A Person who can swim
```
Scala allows to mix in a trait (creating an anonymous type) when creating a new instance of a class.  

### 6) case classes  
Case classes are regular classes which export their constructor parameters and which provide a recursive decomposition mechanism via pattern matching.  
case classes are used to conveniently store and match on the contents of a class. You can construct them without using new.
```scala  
scala> case class Calculator(brand: String, model: String)
defined class Calculator

scala> val hp20b = Calculator("HP", "20b")
hp20b: Calculator = Calculator(hp,20b)
```

case classes automatically have equality and nice toString methods based on the constructor arguments.  
```scala  
scala> val hp20b = Calculator("HP", "20b")
hp20b: Calculator = Calculator(hp,20b)

scala> val hp20B = Calculator("HP", "20b")
hp20B: Calculator = Calculator(hp,20b)

scala> hp20b == hp20B
res6: Boolean = true
```

case classes can have methods just like normal classes.

case classes are designed to be used with pattern matching. Let’s simplify our calculator classifier example from earlier.
```scala  
val hp20b = Calculator("HP", "20B")
val hp30b = Calculator("HP", "30B")

def calcType(calc: Calculator) = calc match {
  case Calculator("HP", "20B") => "financial"
  case Calculator("HP", "48G") => "scientific"
  case Calculator("HP", "30B") => "business"
  case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
}
```


### 7) lazy   

The difference between them is, that a val is executed when it is defined whereas a lazy val is executed when it is accessed the first time.

```scala  
scala> val x = { println("x"); 15 }
x
x: Int = 15

scala> lazy val y = { println("y"); 13 }
y: Int = <lazy>

scala> x
res2: Int = 15

scala> y
y
res3: Int = 13

scala> y
res4: Int = 13
```


## Reference  
https://www.scala-lang.org/old/node/104.html  
https://www.cis.upenn.edu/~matuszek/Concise%20Guides/Concise%20Scala.html  
