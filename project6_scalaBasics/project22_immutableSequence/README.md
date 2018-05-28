
# immutableSequence   

  
Sequence is a trait and if you look carefully in the console window, the elements of the Sequence were rendered into a concrete Immutable List.


initialize
```scala
println("Step 1: How to initialize a Sequence with 3 elements")

scala> val seq1: Seq[String] = Seq("Plain Donut", "strawberry Donut", "Chocolate Donut")
seq1: Seq[String] = List(Plain Donut, strawberry Donut, Chocolate Donut)

scala> println(s"Elements of seq1 = $seq1")
Elements of seq1 = List(Plain Donut, strawberry Donut, Chocolate Donut)

```




2.  access elements in Sequence at specific index

```scala

scala> println(s"Element at index 0 = ${seq1(0)}")
Element at index 0 = Plain Donut

scala> println(s"Element at index 1 = ${seq1(1)}")
Element at index 1 = strawberry Donut

scala> println(s"Element at index 2 = ${seq1(2)}")
Element at index 2 = Chocolate Donut


```


3  add elements to Sequence using :+

```scala

val seq2: Seq[String] = seq1 :+ "Vanilla Donut"
println(s"Adding elements to Sequence using :+ = $seq2")

```

4 add two Sequence together using ++

```scala

val seq3: Seq[String] = seq1 ++ Seq[String]("Vanilla Donut", "Glazed Donut")

println(s"Add two sequences together using ++ = $seq3")

```

5 initialize an empty Sequence  
```scala

val emptySeq: Seq[String] = Seq.empty[String]
println(s"Empty Sequence = $emptySeq")

```


