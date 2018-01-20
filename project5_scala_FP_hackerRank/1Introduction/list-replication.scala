
//https://www.hackerrank.com/challenges/fp-list-replication/problem

def f(num:Int,arr:List[Int]):List[Int] = for {e <- arr; _ <- 1 to num} yield e

// version 1
// for{e <- arr; _ <- 1 to num} yield e


// version 2
// arr.flatMap(e => List.fill(num)(e))
