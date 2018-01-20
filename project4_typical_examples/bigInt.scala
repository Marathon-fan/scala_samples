

// aa
/** Bigint's can be used seamlessly */
object bigint {

  def factorial(n: BigInt): BigInt =
    if (n == 0) 1 else n * factorial(n-1)

def main(args: Array[String]) {
  	  val f50 = factorial(50); 
  	  val f49 = factorial(49);
  	  println("50! = " + f50)
      println("49! = " + f49)
      println("50!/49! = " + (f50 / f49))
  	} 
}


// scala examples
// https://www.scala-lang.org/old/node/220.html

// Scala Snippets
// Created by admin on 2008-07-24. Updated: 2009-03-15, 18:38
// Source	Description
// abstractTypes.scala	An example of how abstract types are used in a program
// bigint.scala	User-defined integers, BigInts, are used seamlessly
// complexOps.scala	Operators can be defined on user-defined classes, here complex numbers
// for-yield.scala	An example of the for and yield constructs
// extendBuiltins.scala	Adding "!" as a new method on integers
// implicits.scala	Define a new method 'sort' on arrays without changing their definition
// maps.scala	Maps are easy to use in Scala
// match.scala	Using pattern matching to recognize command line arguments
// primes.scala	A simple, although inefficient, way to calculate prime numbers
// sum.scala	Calculates the sum of the arguments supplied on the command line
// varargs.scala	Java varargs can be easily used in Scala as well
