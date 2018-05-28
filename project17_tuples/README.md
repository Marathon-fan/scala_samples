
# scala


```
scala tuples' indexes are 1-based


```


```scala

scala> def getStockInfo = {
     |   ("NFLX", 100.00, 101.00)
     | }
getStockInfo: (String, Double, Double)


scala> val(symbol, currentPrice, bidPrice) = getStockInfo
symbol: String = NFLX
currentPrice: Double = 100.0
bidPrice: Double = 101.0

scala> val res = getStockInfo
res: (String, Double, Double) = (NFLX,100.0,101.0)

scala> res._1
res2: String = NFLX

scala> res._2
res3: Double = 100.0

scala> res._3
res4: Double = 101.0

```


```
I guess _1, _2 etc it is short for "first", "second", and so on. (fst and snd for instance have historically been used for accessing the left and right part of a tuple). The index in an array on the other hand is an offset and the first element is usually at offset 0.

Are there any mathematical/programming benefits in having 1-based indexed tuples and not 0-based?

No. The elements are not accessed programatically anyway. (You can't do _i if i is an integer.)

```



## 1 Tupled to pass tuples to functions in Scala


Tupled to pass tuples to functions in Scala
When using tuples within Scala the tuple function can be use to convert a function which takes multiple parameters to accept just the tuple keeping the code more concise.

```
object ApplyFunctionToATuple {

  def addition(a: Int, b: Int) = a + b

  val pairOfNumbers = (1, 2)
  addition(pairOfNumbers._1, pairOfNumbers._2) // Extract values and apply
  Function.tupled(addition _)(pairOfNumbers) // Scala 2.7 version
  (addition _).tupled(pairOfNumbers) // Scala 2.8 version
}
```
