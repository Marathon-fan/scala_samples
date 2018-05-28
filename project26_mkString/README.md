
# mkString    



```scala

scala> val args = Array("Hello", "world", "it's", "me")
args: Array[String] = Array(Hello, world, it's, me)

scala> val s = args.mkString(" ")
s: String = Hello world it's me

scala> val s = Array("thisfs", "aaaaa", "bbbbb", 1)
s: Array[Any] = Array(thisfs, aaaaa, bbbbb, 1)

scala> s.mkString("-")
res0: String = thisfs-aaaaa-bbbbb-1

```

