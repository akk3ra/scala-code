
def id(a:Int) : Int = a
def sumInt(a: Int, b: Int): Int = {
	if(a>b) 0 else id(a) + sumInt(a+1, b)
}
println("Sum of integers from 3 to 9 is-->>"+sumInt(3,9))

def square(a: Int) : Int = a*a
def squareSums(a:Int, b: Int) : Int = {
	if(a>b) 0  else square(a) + squareSums(a+1,b)
}

println("Sum of squares of integers from 3 to 9 is-->>"+squareSums(3,9))

def sum(f:Int=>Int, a:Int, b:Int): Int = {
	
	if(a>b) 0 else f(a) + sum(f,a+1, b)
}

println("The sum of numbers from 3 to 9 is-->>"+sum(id, 3,9))
println("The sum of squares of numbers from 3 to 9 is -->>"+sum(square, 3,9))
