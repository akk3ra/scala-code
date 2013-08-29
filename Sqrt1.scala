import Math.abs
def Sqrt(x:Double) = process(y=> (y+ x/y)/2)(35.0)
def process(f:(Double)=>Double)(fg:Double) {	
	def iterate(g:Double):Double = {
		val next = f(g)
	//	println(next)
		if(isCloseEnough(fg, next)) next else iterate(next)
	}
	iterate(fg)
}
def isCloseEnough(x:Double, y:Double):Boolean = abs((y-x)/x) < tolerance
def tolerance = 0.0001 
println(Sqrt(1000.0))
