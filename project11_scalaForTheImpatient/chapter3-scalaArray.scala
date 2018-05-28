


working with arrays

Key points of this chapter:
• Use an Array if the length is fixed, and an ArrayBuffer if the length can vary.
• Don’t use new when supplying initial values.
• Use () to access elements.
• Use for (elem <- arr) to traverse the elements.
• Use for (elem <- arr if . . . ) . . . yield . . . to transform into a new array.
• Scala and Java arrays are interoperable; with ArrayBuffer, use scala.collection.
JavaConversions.


////////////////////////////////////////////////////
1 fixed-length arrays
val 

```
val nums = new Array[Int](10)
// An array of ten integers, all initialized with zero
val a = new Array[String](10)
// A string array with ten elements, all initialized with null
val s = Array("Hello", "World")
// An Array[String] of length 2—the type is inferred // Note: No new when you supply initial values
s(0) = "Goodbye"
// Array("Goodbye", "World")
// Use () instead of [] to access elements
```
////////////////////////////////////////////////////



////////////////////////////////////////////////////


////////////////////////////////////////////////////



////////////////////////////////////////////////////




////////////////////////////////////////////////////


////////////////////////////////////////////////////


////////////////////////////////////////////////////



////////////////////////////////////////////////////




////////////////////////////////////////////////////


////////////////////////////////////////////////////


////////////////////////////////////////////////////

You can use :+ to append element to array and +: to prepend it:

0 +: array :+ 4
should produce:
res3: Array[Int] = Array(0, 1, 2, 3, 4)


It's the same as with any other implementation of Seq.




////////////////////////////////////////////////////Exercise





Q1:
1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).

```
import scala.util.Random

def setRandom(n:Int) = {
	new Array[Int](n).map( _ => Random.nextInt(n))
}

```


def swap[T](array:Array[T]) = {
	for (i <- 0 until array.length -1 by 2) {
		val tmp = array(i)
		array(i) = array(i + 1)
		array(i + 1) =  tmp
	}
	array
}


Q2. Write a loop that swaps adjacent elements of an array of integers. 
For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
// Here, ensure you use `Array` and not `List`, as a list in scala is immutable.
```
scala> def swap[T](array:Array[T]) = {
     |   for (i <- 0 until array.length -1 by 2) {
     |           val tmp = array(i)
     |           array(i) = array(i + 1)
     |           array(i + 1) =  tmp
     |   }
     |   array
     | }
swap: [T](array: Array[T])Array[T]

scala> 

scala> sway(Array(2,3,4,5,6,7,8))
<console>:12: error: not found: value sway
       sway(Array(2,3,4,5,6,7,8))
       ^

scala> swap(Array(2,3,4,5,6,7,8))
res1: Array[Int] = Array(3, 2, 5, 4, 7, 6, 8)



scala> swap(Array.apply("str1","str2", "str3", "str4", "str5"))
res3: Array[String] = Array(str2, str1, str4, str3, str5)
```

Q3: Repeat the preceding assignment, but produce a new array with the swapped values. Use for/yield.

```
def swapList[T](array: Array[T]) = {
	val res = for (i <- 0 until array.length) yield
		if (i % 2 == 1)
			array(i - 1)
		else if (i != array.length - 1)
			array(i + 1)
		else 
			array(i)
	res	
}

scala> swapList(Array(1,2,3,4,5,6,7))
res6: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 1, 4, 3, 6, 5, 7)



scala> swapList(Array(1,2,3,4,5,6))
res7: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 1, 4, 3, 6, 5)

```



Q4:  
Given an array of integers, produce a new array that contains all positive values of the original array,
in their original order, followed by all values that are zero or negative, in their original order.

```scala
def func(input: Array[Int]) = {
	input.filter( _ > 0 ) ++ input.filter(_ <= 0)
}

```







////////////////////////////////////////////////////


////////////////////////////////////////////////////


////////////////////////////////////////////////////



////////////////////////////////////////////////////




////////////////////////////////////////////////////

