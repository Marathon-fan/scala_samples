
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
flatMap works applying a function that returns a sequence for each element in the list, and flattening the results into the original list. 
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

```
scala> List(1, 2, 3).map(x => List(x, x + 0.5))
res12: List[List[Double]] = List(List(1.0, 1.5), List(2.0, 2.5), List(3.0, 3.5))

```

```
scala> List(1, 2, 3).map(x => List(x, x + 0.5)).reduceLeft(_ ++ _)
res13: List[Double] = List(1.0, 1.5, 2.0, 2.5, 3.0, 3.5)
```

```
scala> val a = Array(20, 12, 6, 15, 2, 9)
a: Array[Int] = Array(20, 12, 6, 15, 2, 9)

scala> 

scala> a.reduceLeft(_ min _)
res14: Int = 2

scala> a.reduceLeft(_ max _)
res15: Int = 20


```


```scala
    val dbSFTestConnection = Connections.getSaleForceSchemaDBObject().db

    val assetAndLiabilityQuery = AssetAndLiabilities.filter(al => al.opportunity_C === request.body.Opportunity__c_al).map(
      x => (
        x.limit_C,
        x.clearingFromThisLoan_C,
        x.usedAsSecurity_C,
        ...
      )
    )

    val result_assetAndLiabilityQuery = dbSFTestConnection.run(assetAndLiabilityQuery.result)
    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.duration._
    Await.result(result_assetAndLiabilityQuery, 10.seconds)
    println("--==--==--=--==--==-==--==--==--==begin to print result_assetAndLiabilityQuery")
    result_assetAndLiabilityQuery.map { data => {
      val dataList = data.toList
      dataList.foreach(println)

      /////////////
            dataList.map(item => {
              val output = item match{
                case (v1, v2, v3, v4, v5, ....) => {
                  println(v1)
                  println(v2)
                  println(v3)
                  println(v4)
                  println(v5)
                  ...
                  println("---------------")
                }
              }
            })

     }
    }
```

