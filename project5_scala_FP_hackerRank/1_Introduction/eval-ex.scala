
//https://www.hackerrank.com/challenges/eval-ex/problem

// 

object Solution {

    def main(args: Array[String]) {
        val sc = new java.util.Scanner (System.in);
        var n = sc.nextInt();
        var a0:Int = 0;
        while(a0 < n){
            var x = sc.nextDouble();
            a0 += 1;
            println(f(x, 0))
        }
    }

    def factorial(n:Int):Double = if (n == 0) 1 else n * factorial(n - 1)

    def f(x:Double, num:Int):Double = {
    	val cur:Double = Math.pow(x, num) / factorial(num)
    	if (Math.abs(cur) < 0.01) {
    		return cur 
    	}
    	return  cur + f(x, num + 1) 
    }
} 




