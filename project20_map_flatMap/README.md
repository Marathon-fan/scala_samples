
# map flatMap  

## map      
Map works by applying a function to each element in the list   
```scala
scala> val l = List(1,2,3,4,5)
l: List[Int] = List(1, 2, 3, 4, 5)

scala> l.map(x => x * 2)
res0: List[Int] = List(2, 4, 6, 8, 10)
```


So there are some occasions where you want to return a sequence or list from the function, for example an Option
```scala
scala> def f(x:Int) = if (x > 2) Some(x) else None
f: (x: Int)Option[Int]

scala> l.map(x => f(x))
res1: List[Option[Int]] = List(None, None, Some(3), Some(4), Some(5))
```

## flatMap  
flatMap works applying a function that returns a sequence for each element in the list, and flattening the results into the original list(a plain list without nested structure). 
```scala
scala> l.map(x => f(x))
res1: List[Option[Int]] = List(None, None, Some(3), Some(4), Some(5))

scala> def g(v:Int) = List(v-1, v, v+1)
g: (v: Int)List[Int]

scala> l.map(x => g(x))
res2: List[List[Int]] = List(List(0, 1, 2), List(1, 2, 3), List(2, 3, 4), List(3, 4, 5), List(4, 5, 6))

scala> l.flatMap(x => g(x))
res3: List[Int] = List(0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 6)


```



