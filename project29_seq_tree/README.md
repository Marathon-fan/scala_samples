
# Vector    


What is a Vector?
```
As per the Scala Documentation, a Vector is data structure which is similar to a List. However, it addresses the inefficiencies of random access within a List.
```

```
scala> val vector1: Vector[String] = Vector("Plain Donut", "Strawberry Donut", "Chocolate Donut")
vector1: Vector[String] = Vector(Plain Donut, Strawberry Donut, Chocolate Donut)

```



1. access elements of Vector at specific index
```
scala> println(s"Element at index 0 = ${vector1(0)}")
Element at index 0 = Plain Donut

scala> println(s"Element at index 1 = ${vector1(1)}")
Element at index 1 = Strawberry Donut

scala> println(s"Element at index 2 = ${vector1(2)}")
Element at index 2 = Chocolate Donut
```



2. append elements at the end of Vector using :+

```
scala> val vector2 = vector1 :+ "Vanilla Donut"
vector2: scala.collection.immutable.Vector[String] = Vector(Plain Donut, Strawberry Donut, Chocolate Donut, Vanilla Donut)

scala> println(s"Adding elements to Vector using :+ = $vector2")
Adding elements to Vector using :+ = Vector(Plain Donut, Strawberry Donut, Chocolate Donut, Vanilla Donut)
```


3. prepend elements in front of Vector using +:


4. initialize an empty Vector

```
scala> val emptyVector: Vector[String] = Vector.empty[String]
emptyVector: Vector[String] = Vector()
```

