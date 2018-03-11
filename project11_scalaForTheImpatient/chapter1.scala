



scala> val anser = 8 * 5 + 2
anser: Int = 42


////////////////////////////////////////////////////
scala> val greeting: String = null
greeting: String = null

scala> val greeting: Any = "Hello"
greeting: Any = Hello




////////////////////////////////////////////////////

scala> val xmax, ymax = 100
xmax: Int = 100
ymax: Int = 100

scala> var greeting, message: String = null
greeting: String = null
message: String = null



////////////////////////////////////////////////////
//Commonly Used Types
scala> 1.to(10)
res11: scala.collection.immutable.Range.Inclusive = Range 1 to 10

scala> println(res11)
Range 1 to 10   

// the Int value 1 is first converted to a RichInt, and the to method is applied to that
// value.

////////////////////////////////////////////////////
scala> "Hello".intersect("World")
res13: String = lo

// In this expression, the java.lang.String object "Hello" is implicitly converted to a
// StringOps object, and then the intersect method of the StringOps class is applied.
scala>  "Heoll".intersect("World")
res15: String = ol

////////////////////////////////////////////////////
//Arithmetic and Operator Overloading
a+ b  
is a shorthand for  
a.+(b)  


 For
example, instead of
1.to(10)
you can write
1 to 10


scala> 1 to 10
res16: scala.collection.immutable.Range.Inclusive = Range 1 to 10

   

////////////////////////////////////////////////////

There is one notable difference between Scala and Java or C++. Scala does not have ++ or -- operators. 
Instead, simply use +=1 or -=1:

counter+=1 // Increments counter—Scala has no ++

////////////////////////////////////////////////////
You can use the usual mathematical operators with BigInt and BigDecimal objects:

val x: BigInt = 1234567890
x * x * x // Yields 1881676371789154860897069000
That’s much better than Java, where you would have had to call
x.multiply(x).multiply(x).


////////////////////////////////////////////////////

Scala has functions in addition to methods. 

scala> Math.sqrt(2)
res20: Double = 1.4142135623730951

scala> Math.pow(2, 3)
res21: Double = 8.0



////////////////////////////////////////////////////
Often, a class has a companion object whose methods act just like static methods do in Java. For example, the BigInt companion object to the 
igInt class has a method probablePrime that generates a random prime number with a given number of bits:
BigInt.probablePrime(100, scala.util.Random)
Try this in the REPL; you’ll get a number such as 1039447980491200275486540240713.
Note that the call BigInt.probablePrime is similar to a static method call in Java.

scala> BigInt.probablePrime(100, scala.util.Random)
res24: scala.math.BigInt = 1175953479717281473891439404547

scala> BigInt.probablePrime(100, scala.util.Random)
res25: scala.math.BigInt = 746682942641678778555172833511

////////////////////////////////////////////////////
Scala methods without parameters often don’t use parentheses.

scala> "hello".distinct
res26: String = helo

////////////////////////////////////////////////////
The apply Method

For example,
if s is a string, then s(i) is the ith character of the string.

scala> "hello"(4)
res27: Char = o

scala> "hello".apply(4)
res28: Char = o

 in the documentation of the StringOps class, you will find a method
def apply(n: Int): Char
That is, "Hello"(4) is a shortcut for
"Hello".apply(4)

scala> BigInt("1234567890")
res30: scala.math.BigInt = 1234567890

BigInt("1234567890") is a shortcut for BigInt.apply("1234567890")
It yields a new BigInt object, without having to use new. 

scala> BigInt("1234567890") * BigInt("112358111321")
res31: scala.math.BigInt = 138713716417952082690


////////////////////////////////////////////////////

Methods can have functions as parameters. For example, the count method in StringOps requires a function that returns true or false for 
a Char, specifying which characters should be counted:

def count(p: (Char) => Boolean) : Int


////////////////////////////////////////////////////
RichInt

In Scala, the Relationship between Int and RichInt is that when we use Int in a Scala program, 
it will automatically convert into RichInt to utilize all methods available in that Class. 
We can say that RichInt is an Implicit class of Int. (We will discuss “What is Implicit and the 
	advantages of Implicits in my next post).


////////////////////////////////////////////////////
RichDouble

////////////////////////////////////////////////////
StringOps

abstract def
patch(from: Int, that: GenSeq[Char], replaced: Int): StringOps[A]
[use case] Produces a new string where a slice of elements in this string is replaced by another sequence.

scala> "Harry".patch(1, "ung", 2)
res32: String = Hungry


////////////////////////////////////////////////////
////////////////////////////////////////////////////
////////////////////////////////////////////////////
chapter1 exercises
1 

2 
scala> Math.sqrt(3) * Math.sqrt(3)
res33: Double = 2.9999999999999996

3 
Are the res variables val or var?

val

4
Scala lets you multiply a string with a number—try out "crazy" * 3 in the REPL.
What does this operation do? Where can you find it in Scaladoc?

///////

scala> "crazy" * 3
res36: String = crazycrazycrazy
///////

scala.collection.immutable.StringOps
def
*(n: Int): String
Return the current string concatenated n times.

5
What does 10 max 2 mean? In which class is the max method defined?

///////
scala> 10 max 2
res37: Int = 10

///////
scala.runtime.RichInt

def max(that: Int): Int
Returns this if this > that or that otherwise.

Definition Classes
RichInt → ScalaNumberProxy


6
Using BigInt, compute "2 to the power of 1024"
println( BigInt(2).pow(1024))

7
What do you need to import so that you can get a random prime as probablePrime(100, Random), 
without any qualifiers before probablePrime and Random?
//////// 
import scala.BigInt.probablePrime
import scala.util.Random

println(probablePrime(100, Random))
//////// 

8
One way to create random file or directory names is to produce a random BigInt and convert it to 
base 36, yielding a string such as "qsnvbevtomcj38o06kul". 
Poke around Scaladoc to find a way of doing this in Scala.


//////// 

import scala.BigInt.probablePrime
import scala.util.Random

 println(
    probablePrime(200, Random).toString(36)
  )
 
//////// 
scala.math
BigInt
def probablePrime(bitLength: Int, rnd: Random): BigInt
Returns a positive BigInt that is probably prime, with the specified bitLength.

class BigInt(val bigInteger : java.math.BigInteger)
extends java.lang.Number with AnyRef
 def	toString (radix : Int) : java.lang.String
Returns the String representation in the specified radix of this BigInt.


9. How do you get the first character of a string in Scala? The last character?
val str = "123456789"
println(str(0))
println(str.last)

val sts = ""
println(sts(0))
println(sts.head)
println(sts.last)

java.lang.StringIndexOutOfBoundsException: String index out of range: 0
  at java.lang.String.charAt(String.java:658)
  at scala.collection.immutable.StringOps$.apply$extension(StringOps.scala:37)
  ... 28 elided

scala> println(sts.last)
java.util.NoSuchElementException: next on empty iterator
  at scala.collection.Iterator$$anon$2.next(Iterator.scala:38)
  at scala.collection.Iterator$$anon$2.next(Iterator.scala:36)
  at scala.collection.IndexedSeqLike$Elements.next(IndexedSeqLike.scala:60)
  at scala.collection.IterableLike.head(IterableLike.scala:106)
  at scala.collection.IterableLike.head$(IterableLike.scala:105)

10
What do the take, drop, takeRight, and dropRight string functions do? What advantage or disadvantage do they have 
over using substring?

  val s = "brilliant"

  assert( s.take(2) == "br" )
  assert( s.drop(2) == "illiant" )
  assert( s.takeRight(2) == "nt" )
  assert( s.dropRight(2) == "brillia" )

  // advantages: chain
  assert( s.drop(2).take(3) == "ill" )

////////////////////////////////////////////////////


////////////////////////////////////////////////////



////////////////////////////////////////////////////


////////////////////////////////////////////////////



////////////////////////////////////////////////////

