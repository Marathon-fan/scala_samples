
# List   



Lists are homogeneous and covariant
 ```scala
scala>  List(1,2,3)
res0: List[Int] = List(1, 2, 3)

scala> List.apply(1,2,3)
res1: List[Int] = List(1, 2, 3)

scala> val fruit = List("apples", "oranges", "pears")
fruit: List[String] = List(apples, oranges, pears)


scala> val matrix = List(
     | List(1,2,3),
     | List(4, 5, 6),
     | List(7,8,9)
     | )
matrix: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))

scala> matrix.transpose
res2: List[List[Int]] = List(List(1, 4, 7), List(2, 5, 8), List(3, 6, 9))

scala> List.empty
res3: List[Nothing] = List()

scala> Nil
res4: scala.collection.immutable.Nil.type = List()

scala> Nil == List.empty
res5: Boolean = true

scala> Vector.empty
res10: scala.collection.immutable.Vector[Nothing] = Vector()

scala> case class Person(first:String, last: String, age:Int)
defined class Person

scala> val p = Person("Fred", "Bloggs", 22)
p: Person = Person(Fred,Bloggs,22)

scala> p :: fruit
res11: List[java.io.Serializable] = List(Person(Fred,Bloggs,22), apples, oranges, pears)

scala> 1 :: fruit
res12: List[Any] = List(1, apples, oranges, pears)

scala> val fAsAny: List[Any] = fruit
fAsAny: List[Any] = List(apples, oranges, pears)

scala> def lenOfList(xs: List[Any]):Int = xs.length
lenOfList: (xs: List[Any])Int

scala> lenOfList(fruit)
res13: Int = 3

scala> val nums = List(1,2,3,4)
nums: List[Int] = List(1, 2, 3, 4)

scala> lenOfList(nums)
res14: Int = 4


 ``` 

constructing lists
```
scala> 1 :: 2 :: 3 :: Nil
res4: List[Int] = List(1, 2, 3)

scala>   (1::(2::(3 :: Nil)))
res6: List[Int] = List(1, 2, 3)



```

basic operations on lists
```
head

tail
isEmpty
Nil

Nil.isEmpty

scala> 1::Nil
res9: List[Int] = List(1)

scala> res9.isEmpty
res10: Boolean = false

scala> val fruit=List("apples", "bananas", "pears")
fruit: List[String] = List(apples, bananas, pears)

scala> val (head :: tail) = fruit
head: String = apples
tail: List[String] = List(bananas, pears)

scala> val (head::tail) = res9
head: Int = 1
tail: List[Int] = List()


scala> res9.tail
res11: List[Int] = List()


```


