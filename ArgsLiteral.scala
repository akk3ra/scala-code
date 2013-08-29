def calcDiscount(f:Int=>Int, g:String=>Int, a:Int): Float  = {
	val ranks = Map(1->"Sandeep", 2->"Deepika", 3->"Isha")
	var disc = 0
	def check(): Boolean = {
		var stat= false
		if(ranks(a)==null) stat = false else stat = true
		stat
	}
	
	if(check()){
		
		disc = 	f(a)*g(ranks(a))%100
	}
	
	disc
   }

println(calcDiscount(x=>x*x, y=>{
var len = 0
if(y.length==0) len = 0
else len = y.length
len	
}, 1))

