




Here are the highlights of this chapter:

• An if expression has a value.
• A block has a value—the value of its last expression.
• The Scala for loop is like an “enhanced” Java for loop.
• Semicolons are (mostly) optional.
• The void type is Unit.
• Avoid using return in a function.
• Beware of missing = in a function definition.
• Exceptions work just like in Java or C++, but you use a “pattern matching” syntax for catch.
• Scala has no checked exceptions.

////////////////////////////////////////////////////
in Scala, an if/else has a value, namely the value of the expression that follows the if or else.

```
scala> def x:Int = 1;
x: Int

scala> println(if (x > 0) 100 else -100)
100


scala> val s = if (x > 0) 1 else -1
s: Int = 1


scala> println(if (x > 0) "positive" else -1)
positive


scala> println(if (x < 0) "negative" )
()



```


The type of a mixed-type expression, such as
if (x > 0) "positive" else -1
is the common supertype of both branches. In this example, one branch is a java.lang.String, and the other an Int. Their common supertype is called Any. 

in Scala, every expression is supposed to have some value. This is finessed by introducing a class Unit that has one value, written as (). The if statement without an else is equivalent to
if (x > 0) 1 else ()

Technically speaking, void has no value whereas Unit has one value that signifies “no value”. If you are so inclined, you can ponder the difference between an empty wallet and a wallet with a bill labeled “no dollars”.


////////////////////////////////////////////////////
TIP: If you want to paste a block of code into the REPL without worrying about its nearsightedness, use paste mode. Type
:paste
Then paste in the code block and type Ctrl+K. The REPL will then analyze the block in its entirety.

////////////////////////////////////////////////////
In Scala, a { } block contains a sequence of expressions, and the result is also an expression. The value of the block is the value of the last expression.
This feature can be useful if the initialization of a val takes more than one step. For example,
```
scala> val X0:Double = 5.0;
X0: Double = 5.0

scala> val y0:Double = 6.0;
y0: Double = 6.0

scala> val x:Double = 4;
x: Double = 4.0

scala> val y:Double =3;
y: Double = 3.0                                                        

scala> val distance = {val dx = x - X0; val dy = y - y0; Math.sqrt(dx * dx + dy * dy)}
distance: Double = 3.1622776601683795
```

////////////////////////////////////////////////////



A block that ends with an assignment statement, such as
{ r = r * n; n -= 1 }
has a Unit value. 


scala> var r = 3;
r: Int = 3

scala> var s = 5;
s: Int = 5

scala> println({r = r * s; s -= 1})
()


Since assignments have Unit value, don’t chain them together. 
x = y = 1 // No

```
scala> var a = 0;
a: Int = 0

scala> var b = 3;
b: Int = 3

scala> a = b = 1;
<console>:13: error: type mismatch;
 found   : Unit
 required: Int
       a = b = 1;
             ^

```

////////////////////////////////////////////////////

loops
```
scala> a = 10
a: Int = 10

scala> for (i <- 1 to a) 
     | println(i)
1
2
3
4
5
6
7
8
9
10
```


When traversing a string or array, you often need a range from 0 to n – 1. In that case, use the until method instead of the to method. It returns a range that doesn’t include the upper bound.

```
scala> val s = "hello"
s: String = hello

scala> var sum = 0
sum: Int = 0

scala> for (i <- 0 until s.length)
     | sum += s(i)

scala> println(sum)
532

scala> 
```

You can directly loop over the characters:
```

scala> sum = 0;
sum: Int = 0

scala> for (ch <- s) sum += ch

scala> println(sum)
532

```

Scala has no break or continue statements to break out of a loop. What to do if you need a break? Here are a few options:
1. Use a Boolean control variable instead.
2. Use nested functions—you can return from the middle of a function.
3. Use the break method in the Breaks object:



////////////////////////////////////////////////////
Advanced for Loops and for Comprehensions
```
scala> for (i <- 1 to 3; j <- 1 to 3) print( (10 * i + j) + " ")
11 12 13 21 22 23 31 32 33 
```



////////////////////////////////////////////////////


Each generator can have a guard, a Boolean condition preceded by if: 

for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10 * i + j) + " ")

// Prints 12 13 21 23 31 32
Note that there is no semicolon before the if.

scala> for (i <-1 to 3; j <- 1 to 3 if i != j) print( (10 * i + j) + " ")
12 13 21 23 31 32 

scala> for (i <- 1 to 3; from = 4 - i; j <- from to 3) print((10 * i + j) + " ")
13 22 23 31 32 33 


When the body of the for loop starts with yield, then the loop constructs a collection of values, one for each iteration:

scala> for (i <- 1 to 10) yield i % 3
res14: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)

The generated collection is compatible with the first generator.

scala> for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
res15: String = HIeflmlmop

scala> for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar
res16: scala.collection.immutable.IndexedSeq[Char] = Vector(H, e, l, l, o, I, f, m, m, p)



////////////////////////////////////////////////////

Scala has functions in addition to methods. A method operates on an object, but a function doesn’t.

scala> def abs(x: Double) = if(x >= 0) x else -x
abs: (x: Double)Double

scala> println(abs(-50))
50.0

scala> def fac(n: Int) = {
     | var r = 1;
     | for (i <- 1 to n) r = r * i
     | r
     | }
fac: (n: Int)Int

scala> println(fac(5))
120



With a recursive function, you must specify the return type. For example,
def fac(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)
Without the return type, the Scala compiler couldn’t verify that the type of
n * fac(n - 1) is an Int.

scala> def fac1(n : Int) : Int = if(n <= 0) 1 else n * fac(n - 1)
fac1: (n: Int)Int

scala> println(fac1(6))
720

////////////////////////////////////////////////////
2.8 Default and Named Arguments

scala> def decorate(str: String, left: String = "[", right: String = "]") = left + str + right
decorate: (str: String, left: String, right: String)String



scala> decorate("Hello", right = "]<<<")
res4: String = [Hello]<<<



////////////////////////////////////////////////////

Variable Arguments

//The following function receives a single parameter of type Seq
scala> def sum(args: Int*) = {
     |   var result = 0;
     |   for (arg <- args) result += arg
     |   result
     | }
sum: (args: Int*)Int

scala> println(sum(1,2,4,56,8,9,-1))
79

scala> val s = sum(1 to 5: _*)
s: Int = 15

This call syntax is needed in a recursive definition:


scala> def sum1(args: Int*): Int = {
     |   if (args.length == 0) 0
     |   else args.head + sum1(args.tail : _*)
     | }
sum1: (args: Int*)Int

scala> println(sum1(3))
3

scala> println(sum1(5))
5

scala> println(sum1(1 to 5 : _*))
15




////////////////////////////////////////////////////

When a val is declared as lazy, its initialization is deferred until it is accessed for the first time.

val words = scala.io.Source.fromFile("/usr/share/dict/words").mkString // Evaluated as soon as words is defined

lazy val words = scala.io.Source.fromFile("/usr/share/dict/words").mkString // Evaluated the first time words is used

def words = scala.io.Source.fromFile("/usr/share/dict/words").mkString // Evaluated every time words is used


////////////////////////////////////////////////////
unlike Java, Scala has no “checked” exceptions—you never have to declare that a function or method might throw an exception.

scala> val x = -1;
x: Int = -1


scala> if (x >= 0) {
     |   Math.sqrt(x)
     | } else throw new IllegalArgumentException("x should not be negative")
java.lang.IllegalArgumentException: x should not be negative
  ... 30 elided


////////////////////////////////////////////////////
////////////////////////////////////////////////////
////////////////////////////////////////////////////
////////////////////////////////////////////////////
////////////////////////////////////////////////////
chapter2 exercises
1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero. Write a function that computes this value.
```

scala> def signum(input:Double) = {
     |   if (input > 0) 1
     |   else if (input < 0) -1
     |   else 0
     | }
signum: (input: Double)Int

scala> println(signum(-100));
-1

scala> println(signum(10));
1

scala> 

scala> println(signum(0));
0

```

2. What is the value of an empty block expression {}? What is its type?
scala> println({})
()  //scala.Unit


3. Come up with one situation where the assignment x = y = 1 is valid in Scala.
(Hint: Pick a suitable type for x.)
def func() : Unit = {
	var x: Unit = ();
	var y:Int = 2;
	x = y = 1;
}


4. Write a Scala equivalent for the Java loop
for (int i = 10; i >= 0; i--) System.out.println(i);
```
for (i <- 10 to (0, -1)) println(i) // 

```

5. Write a procedure countdown(n: Int) that prints the numbers from n to 0.

```
scala> def countdown1(n:Int):Unit = {
     |   for (i <- n to (0, -1)) println(i)
     | }
countdown1: (n: Int)Unit


scala> countdown1(4)
4
3
2
1
0
```

6. Write a for loop for computing the product of the Unicode codes of all letters in a string. 
For example, the product of the characters in "Hello" is 825152896.


scala> def func2(input: String):BigInt = {
     |   var res:BigInt = 1;
     |     for (cur<-input) {
     |           res = res * cur.toInt;  
     |           println(cur.toInt);  
     |     }
     |     res
     | }
func2: (input: String)BigInt

scala> println(func2("Hello"))
72
101
108
108
111
9415087488

7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)
scala> def func6(Input: String):BigInt = {
     |    Input.map(BigInt(_)).product
     | }
func6: (Input: String)BigInt


scala> println(func6("Hello"))
9415087488

8. Write a function product(s : String) that computes the product, as described in the preceding exercises.

scala> def product(s : String):BigInt = {
     |   var res: BigInt = 1;
     |   s.map(BigInt(_)).product
     | }
product: (s: String)BigInt

scala> product("Hello")
res11: BigInt = 9415087488

9. Make the function of the preceding exercise a recursive function.

scala> def recursiveProduct(s : String):BigInt = {
     |   if (s.isEmpty) {
     |           return 1;
     |   }
     |   BigInt(s.head) * recursiveProduct(s.tail)
     | }
recursiveProduct: (s: String)BigInt

scala> println(recursiveProduct("Hello"))
9415087488

10.

def func8(x:Double, n: Int):Double = {
	if (n < 0) 1 / func8(x, n * -1)
	else if (n == 0) 1
    else if (n % 2 == 0) {
    	var tmp:Double = func8(x, n / 2);
    	tmp * tmp
    } else x * func8(x, n - 1)
}

scala> def func8(x:Double, n: Int):Double = {
     |   if (n < 0) 1 / func8(x, n * -1)
     |   else if (n == 0) 1
     |     else if (n % 2 == 0) {
     |           var tmp:Double = func8(x, n / 2);
     |           tmp * tmp
     |     } else x * func8(x, n - 1)
     | }
func8: (x: Double, n: Int)Double

scala> println(func8(2,4))
16.0

scala> println(func8(2,-4))
0.0625

scala> println(func8(2,5))
32.0

scala> println(func8(2,0))
1.0



////////////////////////////////////////////////////

