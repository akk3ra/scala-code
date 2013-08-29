def sum(f:Int => Int, a:Int, b: Int): Int = {
	if(a>b)0 else f(a) + sum(f, a+1, b)
		
}
println("The sum of squares of the numbers from 3 to 9 is-->>"+sum(x=>x*x,3,9))
