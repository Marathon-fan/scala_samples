
# seq tree


LinearSeq: efficient head and tail. access to a normal element uses linear time(like singly/doubly-linked list)

example: List and Stream  

IndexSeq: efficient apply, length, and (if mutable) update   
examples:  
Array and ArrayBuffer(Buffers allow element insertions, removals and efficient appending)    



![alt text](https://github.com/Marathon-fan/scala_samples/blob/master/project6_scalaBasics/project29_seq_tree/scala_seq_tree.png)

////////////////////////////////////////////////////////////////////////////////////////////////

scala seq method
```
Method	Description
def contains[A1 >: A](elem: A1): Boolean	Check whether the given element present in this sequence.
def copyToArray(xs: Array[A], start: Int, len: Int): Unit	It copies the seq elements to an array.
def endsWith[B](that: GenSeq[B]): Boolean	It tests whether this sequence ends with the given sequence or not.
def head: A	It selects the first element of this seq collection.
def indexOf(elem: A): Int	It finds index of first occurrence of a value in this immutable sequence.
def isEmpty: Boolean	It tests whether this sequence is empty or not.
def lastIndexOf(elem: A): Int	It finds index of last occurrence of a value in this immutable sequence.
def reverse: Seq[A]	It returns new sequence with elements in reversed order.
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




