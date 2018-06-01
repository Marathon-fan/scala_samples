
# Either, Left, and Right   


Either works just like Option, with a difference being that with Either you can return a String that describes the problem that occurred. Actually, what you do is wrap the String inside of Left. Actually ... what you really do is return anything you want inside of Left, though returning information about the problem is generally the intention, so as a practical matter you typically return a String.


Here’s a quick comparison of the Option and Either approaches:
```
Either is just like Option
Right is just like Some
Left is just like None, except you can include content with it to describe the problem
```

```scala
scala> var s:Seq[Int] = Seq(1,2,3,4,5,6,7)
s: Seq[Int] = List(1, 2, 3, 4, 5, 6, 7)

scala> s.foreach(i => println(i + 10))
11
12
13
14
15
16
17
```









