# scala


## 1 scala projects
### project1_async(Futures and Scala Async)    
this project demonstrates how to use async(Futures and Scala Async)  
```
1) $> cd project1
2) $> sbt  
3) $> run  

```
### project2_use MacWire to make DI(dependency injection)      
this project demonstrates how to use MacWire to make DI(dependency injection)  
```
1) $> cd project2
2) $> sbt  
3) $> run  

```
### project3_use Spray api to make REST server      
this project demonstrates how to use Spray api to make REST server
```
1) $> cd project3
2) $> sbt  
3) $> run  
```

### project4_typical_examples  
this project gives typical examples of scala languages  

### project5_scala_FP_hackerRank  
this project gives answers to problems from FP_hackerRank  

### project7_play_WebApp(sample)      
how to run it  
1) cd the project folder  
2) $> ./sbt run  
3) navigate to http://localhost:9000/ and you will see the page  

### project8_ScalatraSlickScalaTestAngularMySQLDocker  
use Scalatra(scala), Slick(scala), ScalaTest(sclala), Angular(Angular4, typescript), MySQL, and Docker(Dockerfile, dockercompose) to build a fullstack project with CRUD functionality for users and posts.

### project9_reactiveKafkaScalaExample  
use Akka stream, kafka and scala together  


## 2 scala basics  

### how to initialize a scala project  
http://www.scala-sbt.org/0.13/docs/Hello.html

$> sbt new sbt/scala-seed.g8  
name [My Something Project]: hello  
...  
$> cd hello  
$> sbt  
...  
$> run  


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
scala> class Person(val name:String)
defined class Person

scala> var person1 = new Person("John")
person1: Person = Person@4976085

scala> var person2 = new Person("John")
person2: Person = Person@4aa2877c

scala> 

scala> person1 == person2
res0: Boolean = false //Should be true but is false as we need to override the == method 
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
Case classes are good for modeling immutable data.  
case classes are used to conveniently store and match on the contents of a class. You can construct them without using new.(This is because case classes have an apply method by default which takes care of object construction.)
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


### 8) implicit   
There are three categories of “implicits”;  
Implicit parameters (aka implicit values) will be automatically passed values that have been marked as implicit  
Implicit functions are defs that will be called automatically if the code wouldn’t otherwise compile  
Implicit classes extend behaviour of existing classes you don’t otherwise control (akin to categories in Objective-C)  


Implicit functions will be called automatically if the compiler thinks it’s a good idea to do so. What that means is that if your code doesn’t compile but would, if a call was made to an implicit function, Scala will call that function to make it compile. They’re typically used to create implicit conversion functions; single argument functions to automatically convert from one type to another.

```scala
import akka.actor.{Props, Actor, ActorSystem}

implicit val actorSystem = ActorSystem()
```


### 9) the yield keyword(buffer the for-loop result and return a collection)    

For each iteration of your for loop, yield generates a value which will be remembered. It's like the for loop has a buffer you can’t see, and for each iteration of your for loop another item is added to that buffer. When your for loop finishes running, it will return this collection of all the yielded values. The type of the collection that is returned is the same type that you were iterating over, so a Map yields a Map, a List yields a List, and so on.  
Also, note that the initial collection is not changed; the for/yield construct creates a new collection according to the algorithm you specify.  
```scala
val num = 5
val arr = Array(1, 2, 3, 4, 5)
for {e <- arr; _ <- 1 to num} yield e
```

### 10) ::(cons operator)    
:: (list cons operator. It creates a new list whose head is first argument and whose tail is contents of the second argument.)  
the construction operation :: (pronounced cons): x :: xs gives a new list with the first element x, followed by the elements of xs (which is a list itself).  


```scala
//For example:


list = num :: list

val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
val empty = Nil
```

### scala get type
```scala
    println(someVar.getClass)
    println(someVal.getClass)
```


### var or val  
val immutable    
scala encourages the use of immutable variables to drive side-effort free code  
immutable storage units also help keeep code safe for concurrent/distributed applications  

### scala type inference  
variable types can often be ommitted  
function return trypes can often be ommitted  
polymorphic method calls and generic class instantiations can often be omitted  
```scala
scala> var radius=10.0
radius: Double = 10.0

scala> var radius2 = 10
radius2: Int = 10

scala> var radius:Double = 10
radius: Double = 10.0

scala> var radius:Int = 10.0
<console>:11: error: type mismatch;
 found   : Double(10.0)
 required: Int
       var radius:Int = 10.0


scala> var radius:Double="10.0"
<console>:11: error: type mismatch;
 found   : String("10.0")
 required: Double
       var radius:Double="10.0"

````

statically typed languages: Java, C, C++  

Scala is statically typed, but it has an elaborate type inference system to guess types. so Scala code often looks more like Python code rather than like Java code


### String Operations
String interpolation using s""  
printf notation using f""  
```scala


scala> val greeting ="hello"
greeting: String = hello

scala> greeting + name
res0: String = helloVitthal

scala> greeting + "\n" + name
res1: String =
hello
Vitthal

// you can create multi-line strings using triple quotes

scala> val complicatedGreeting = """You are amazing,
     | incredible,
     | YUGE
     | and ever so gracious
     | """
complicatedGreeting: String =
"You are amazing,
incredible,
YUGE
and ever so gracious
"

scala> val PI = "Pi"
PI: String = Pi

scala> val PI2 = "Pi"
PI2: String = Pi
""
scala> PI == PI2""
res2: Boolean = true

//string interpolcation using s""
scala> s"$greeting, $name, How are you today?"
res3: String = hello, Vitthal, How are you today?


scala> s"""$greeting
     | change a line $name
     | """
res5: String =
"hello
change a line Vitthal
"

//you can create formula using {}
scala> s"${greeting*5}, $name, how are you today?"
res6: String = hellohellohellohellohello, Vitthal, how are you today?


```

1 create multi-line strings using triple quotes  
2 string interpolcation using s""(preface the string with s, then the string can contain variables, delimited by $)
3 you can create formula using {}

Unlike in Java, it  is safe to compare strings using == in scala

```scala
scala> val PI = 3.14159
PI: Double = 3.14159

scala> f"PI evaluates to $PI%.2f"
res7: String = PI evaluates to 3.14


```

### A unified type system  
In Scala, all values are instances of a class(no exceptions)
But, since Scala runs on the JVM, the distinction between value and reference types must still exist somehow

Any  

AnyVal    (Char, Boolean, Int, Double)    

AnyRef    (Collections, Classes, Strings)  

Nothing subtypes AnyVal and AnyRef  

Null only subtypes AnyRef  

### Emptiness in Scala  
null Null Nothing Nil None Unit  

//----
null      basically, the same as null in Java
          reference types can be null, but value types can not
```scala
scala> val z:Int = null
<console>:11: error: an expression of type Null is ineligible for implicit conversion
       val z:Int = null
```

//----
Null       Null is a trait(i.e. a type) not a value  
           Null is the type of null  

//----
Nothing    Nothing is a trait(i.e. a type) not a value  
           Nothing can never be instantiated  
           Nothing 'extends everything'(thus, Nothing is a subtype of both AnyVal and AnyRef)    

```scala
scala> val emptyList = List()
emptyList: List[Nothing] = List()

```

//----
Nil        Nil is a special value associated with an empty List  
           Nil is a singleton instance of List [Nothing]  

```scala
scala> val someList = List(1,2,3,4)
someList: List[Int] = List(1, 2, 3, 4)

scala> var listIter = someList
listInter: List[Int] = List(1, 2, 3, 4)

scala>  while (listIter != Nil) {
     |      | println(listIter.head);
     |      | listIter = listIter.tail
     |      | }
1
2
3
4
```

Lists are internally represented as linked lists, and use this special value(Nil) to signify the end of the list  

//----
None is a special value associated with an Option  
Option is a (monadic) collection used to capture presence or absence of a value  


```scala

scala> def fraction(number:Double, denom:Double): Option[Double]
     | = {
     | if (denom == 0) None
     | else Option(number / denom)
     | }
fraction: (number: Double, denom: Double)Option[Double]

scala> fraction(100, 0)
res2: Option[Double] = None

scala> fraction(22, 7)
res3: Option[Double] = Some(3.142857142857143)


```

monadic
 n. An atom or a radical with a valence of 1.  
In logic and mathematics, a predicate, a relation or a function having an arity of one is called monadic.  
valence noun [ C ] /ˈveɪ·ləns/​ chemistry the ability of an atom to combine with other atoms, measured by the number of electrons it will lose, add, or share  

In logic, mathematics, and computer science, the arity /ˈærɪti/ ( listen) of a function or operation is the number of arguments or operands that the function takes.  

//----
Unit       Unit is basically like void in Java
           Unit is the return type of a function that returns nothing, for instance  




```scala
scala> def printAny(x:Any) {println(x)}
printAny: (x: Any)Unit
```

### Type Operations  
asInstanceOf  
isInstanceOf  
to<Type>  
getClass  


//----
asInstanceOf // a kind of cast


```scala
scala> 123.asInstanceOf[Long]
res0: Long = 123

scala> 123.24.asInstanceOf[Long]
res3: Long = 123

scala> "123.24".asInstanceOf[Long]
java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Long
  at scala.runtime.BoxesRunTime.unboxToLong(BoxesRunTime.java:105)
  ... 28 elided


```


//----
to<Type>  
```scala
scala> 123.24.toLong
res1: Long = 123

scala> "123".toLong
res2: Long = 123

scala> "abc".toLong
java.lang.NumberFormatException: For input string: "abc"
  at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
  at java.lang.Long.parseLong(Long.java:589)
  at java.lang.Long.parseLong(Long.java:631)
  at scala.collection.immutable.StringLike.toLong(StringLike.scala:306)
  at scala.collection.immutable.StringLike.toLong$(StringLike.scala:306)
  at scala.collection.immutable.StringOps.toLong(StringOps.scala:29)
  ... 28 elided

```

//----
isInstanceOf  

```scala
scala> 123.isInstanceOf[Long]
res4: Boolean = false

scala> 123.toLong.isInstanceOf[Long]
res5: Boolean = true

scala> 123.isInstanceOf[Any]
res6: Boolean = true

scala> "123".isInstanceOf[AnyRef]
res7: Boolean = true
```

scala> null.isInstanceOf[Null]
<console>:12: error: type Null cannot be used in a type pattern or isInstanceOf test
       null.isInstanceOf[Null]
                        ^

scala> 123.isInstanceOf[AnyVal]
<console>:12: error: type AnyVal cannot be used in a type pattern or isInstanceOf test
       123.isInstanceOf[AnyVal]
                       ^




//----
getClass



```scala

scala> "123".getClass
res10: Class[_ <: String] = class java.lang.String

scala> List(12, 3).getClass
res12: Class[_ <: List[Int]] = class scala.collection.immutable.$colon$colon



```

### ->  and =>  
//--------------------------------  
->  

-> is used to couple keys and values for a map. So:  
```scala
val m = Map(1 -> "one", 2 -> "two", 3 -> "three")
```
will map the first 3 positive integers into text equivalents (that is, m(1) will be "one", etc.). You could also write it as  
```scala
val m = Map((1,"one"), (2,"two"), (3,"three"))
```
but the first way looks nicer, which is why it's provided as an alternative.


-> is not scala syntax, it is a method of the class ArrowAssoc. When you write "foo" -> "bar", the compiler inserts a implicit conversion from "foo" to ArrowAssoc instance so that the -> method can be found.
```scala
package scala
object Predef {
   class ArrowAssoc[A](x: A) {
       def -> [B](y: B): Tuple2[A, B] = Tuple2(x, y)
      }
      implicit def any2ArrowAssoc[A](x: A): ArrowAssoc[A] =
        new ArrowAssoc(x)
      ...
}
```
google "“scala rich wrappers” to know more.

//--------------------------------  
=>(right arrow/fat arrow)    

=>  // Used for function types, function literals and import renaming
right arrow => which separates the function’s argument list from its body. 



### match expression  
Pattern matching is a mechanism for checking a value against a pattern.   


### def  
A Scala function declaration has the following form −
```scala

def functionName ([list of parameters]) : [return type]
```
Methods are implicitly declared abstract if you don’t use the equals sign and the method body.

Function Definitions
A Scala function definition has the following form −

Syntax
```scala
def functionName ([list of parameters]) : [return type] = {
   function body
   return [expr]
}
```

### _

Existential types
```scala
def foo(l: List[Option[_]]) = ...
```

Higher kinded type parameters
```scala
case class A[K[_],T](a: K[T])
```

Ignored variables
```scala
val _ = 5
```

Ignored parameters
```scala
List(1, 2, 3) foreach { _ => println("Hi") }

Ignored names of self types
```scala
trait MySeq { _: Seq[_] => }
```

Wildcard patterns
```scala
Some(5) match { case Some(_) => println("Yes") }
```

Wildcard imports

```scala
import java.util._
```

Hiding imports
```scala
import java.util.{ArrayList => _, _}
```

Joining letters to punctuation
```scala
def bang_!(x: Int) = 5
```

Assignment operators
```scala
def foo_=(x: Int) { ... }
```

Placeholder syntax
```scala
List(1, 2, 3) map (_ + 2)
```

Partially applied functions
```scala
List(1, 2, 3) foreach println _
```

Converting call-by-name parameters to functions
```scala
def toFunction(callByName: => Int): () => Int = callByName _
```



## scala symbols  
https://docs.scala-lang.org/tutorials/FAQ/finding-symbols.html



## Akka(focuses on actor-based concurrency and other concurrency models)      

Akka is a free and open-source toolkit and runtime simplifying the construction of concurrent and distributed applications on the JVM. Akka supports multiple programming models for concurrency, but it emphasizes actor-based concurrency, with inspiration drawn from Erlang.   

An actor implementation, written by Philipp Haller, was released in July 2006 as part of Scala 2.1.7.[4] By 2008 Scala was attracting attention for use in complex server applications, but concurrency was still typically achieved by creating threads that shared memory and synchronized when necessary using locks. Aware of the difficulties with that approach and inspired by the Erlang programming language's library support for writing highly concurrent, event-driven applications, Jonas Bonér created Akka to bring similar capabilities to Scala and Java. Bonér began working on Akka in early 2009[5] and wrote up his vision for it in June of that year.[6] The first public release was Akka 0.5,[7] announced in January 2010.[8] Akka is now part of the Lightbend Platform together with the Play framework and the Scala programming language.


## play_framework(web application framework that follows MVC)      
Play Framework is an open-source web application framework, written in Scala and also usable from other programming languages that are compiled to Bytecode, e.g. Java, which follows the model–view–controller architectural pattern.  

play project folders  
1) app
  controllers, views  
2) conf  
  application.conf, routes(endponts and their parameters)    
3) project  
  build.properties(after play 2.2, in root folder use build.sbt), plugins.sbt  
4) public   
  static assets such as images, javascripts and stylesheets  
5) test  
  unit tests or acceptance tests   

how to create a play 2+ project?  
1) download start project template from https://example.lightbend.com/v1/download/play-scala-starter-example  
or $> sbt new playframework/play-scala-projectName.g8  (here, sbt should at least be 0.13.13 or higher)  
2) $> ./sbt run  
3) navigate to http://localhost:9000/ and you will see the page    

structure
1) the router  
2) controllers, actions & results  
3) views  
4) data access  
5) the global object(ApplicationSpec.scala, IntegrationSpec.scala..)    

play 2+  
1) new Scala based codebase  
2) Stateless by default  
3) asynchronous by default  

play philosophy  
1) scaling horizontally can be cheaper and more flexible  
2) self hosted, self managed applications can be easily deployed  
3) statelessness allows applications to scale horizontally easily  
4) operations need to be non-blocking to support high concurrency  
  (1) Threads  
  (2) file System IO  
  (3) database connections  
5) holds no opinion on data access and persistence  

play technologies  
1) Play! Executable   
  (1) giter8(play-scala-seed.g8 ) for project templating  
  (2) sbt(simple build tool) for build and Dependency management  
2) play! framework  
  (1) Netty(web server) - play uses netty  
  (2) Akka(concurrency/actor)  - play uses akka  
  (3) Logback(Logging) - play uses logback for logging  
  (4) web technologies(coffeeScript, LESS)  
  (5) HTML5(websockets, server sent events)   
  (6) Data Access(JDBC, JPA, Anorm, H2 Database)  
  (7) Testing(Specs2, Selenium)// you can use these for testing or not use them    

<!-- web framework: play  
Persistence API: JPA  
ORM: Play! with EBean  
Templating Engine: Play!  
reutilize views: Play!  
Server Container: Play!  
management of dependencies: SBT   -->

## Lagom framework(Opinionated microservice framework built on Akka and Play)  
an open source framework for building reactive microservice systems in Java or Scala. Lagom builds on Akka and Play, proven technologies that are in production in some of the most demanding applications today.

Lagom's integrated development environment allows you to focus on solving business problems instead of wiring services together. A single command builds the project, starts supporting components and your microservices, as well as the Lagom infrastructure. The build hot-reloads when it detects changes to source code.

Right-sized services created with Lagom enable:

better defined development responsibilities—to increase agility  
more frequent releases with less risk—to improve time to market  
systems with reactive qualities: responsiveness, resilience, scalability, and elasticticity—to make best use of modern computing environments and meet demanding user expectations  

### message-driven system  
events, commands, and states  


## scala tools  
### twirl  
Twirl is the Play 2 templating language.  

### Casbah  
Casbah is a Scala toolkit for MongoDB.

### add eclipse plugin  
For the latest version:
add the following line to projectFolder/project/plugins.sbt

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.4")  

In sbt use the command eclipse to create Eclipse project files  

$> eclipse  

then we can use eclipse to import the project  

## comparsion  
### stream processing vs   
To me a stream processing system:
```
Computes a function of one data element, or a smallish window of recent data
Computes something relatively simple
Needs to complete each computation in near-real-time — probably seconds at most
Computations are generally independent
Asynchronous – source of data doesn’t interact with the stream processing directly, like by waiting for an answer
```

Stream processing is key if you want analytics results in real time. By building data streams, you can feed data into analytics tools as soon as it is generated and get near-instant analytics results using platforms like Spark Streaming.

Stream processing is useful for tasks like fraud detection. If you stream-process transaction data, you can detect anomalies that signal fraud in real time, then stop fraudulent transactions before they are completed.

A batch processing system to me is just the general case, rather than a special type of processing, but I suppose you could say that a batch processing system:
```
Has access to all data
Might compute something big and complex
Is generally more concerned with throughput than latency of individual components of the computation
Has latency measured in minutes or more
```

Batch processing works well in situations where you don’t need real-time analytics results, and when it is more important to process large volumes of information than it is to get fast analytics results (although data streams can involve “big” data, too – batch processing is not a strict requirement for working with large amounts of data).



## Java trap  

### 1  
Scala is generally easy to learn when coming from Java, but here's a trap: 

If you write: 

  def square(x: int): int { return x * x } 

You get: 

  error: illegal start of declaration 
  def square(x: int): int { return x * x } 

with the error point at the `return'. This is very cryptic, even if it 
makes perfect sense if you know what's going on. (What goes on, in fact, 
is that the block in { ... } is parsed as a refinement of the type 
`int'. Only declarations are allowed in refinements, and the 
`return' is a statement, not a declaration). 




## Reference  
https://www.scala-lang.org/old/node/104.html  
https://www.cis.upenn.edu/~matuszek/Concise%20Guides/Concise%20Scala.html  
https://stackoverflow.com/questions/4980515/scala-maps-operator  
