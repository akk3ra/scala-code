def calcDisc(f:Int=>Int, g:String=>Int, a:Int): Float = {
	val ranks = Map(1->"Sandeep", 2->"Deepika", 3->"Isha")
	var discount:Float = 0
	def check(): Boolean = {
		var stat = false
		if(ranks(a)==null) stat = false else stat = true
		stat 
	}
	if(check()) discount = f(a)*g(ranks(a))%100 else discount = 0
	
	discount
}

def square(a:Int): Int = a*a
def len(a:String): Int = a.length

println(calcDisc(square, len, 3))
