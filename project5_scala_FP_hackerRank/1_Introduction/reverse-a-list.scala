
//https://www.hackerrank.com/challenges/fp-reverse-a-list/problem


def f(arr:List[Int]):List[Int] = arr.foldLeft(List[Int]())((acc,v) => v::acc)

// List[Int] is accumulator, () near List[Int] means that it's an empty List at the beginning; 
// (acc, v) => v:acc is a function that receives accumulator and value from left and 
// than adds this into List - :: operation. try in console: 5::4::3::2::1::Nil

//  signatures of foldLeft
//def foldLeft[B](z: B)(op: (B, A) ⇒ B): B

