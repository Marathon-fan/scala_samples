
# fold   

fold, foldLeft and foldRight



```scala
scala>  val inputList: List[Int] = List(1,3,4)
inputList: List[Int] = List(1, 3, 4)

scala> inputList.foldLeft(0) {(acc,i) => acc + i}
res0: Int = 8

scala> inputList.foldLeft(0)(_ + _)
res1: Int = 8
```









