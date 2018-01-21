
//https://www.hackerrank.com/challenges/fp-sum-of-odd-elements/problem

//version 1
 def f(arr:List[Int]):Int = arr.filter(_ % 2 != 0).sum

//version 2
// def f(arr:List[Int]):Int = arr.filter(_ % 2 != 0).reduceLeft(_ + _)

