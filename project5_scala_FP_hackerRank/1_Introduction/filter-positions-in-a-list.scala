
//https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list/problem


def f(arr:List[Int]):List[Int] = (arr.indices.collect{ case i if i % 2 == 1 => arr(i) }).toList

