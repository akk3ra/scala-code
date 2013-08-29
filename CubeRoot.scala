import Math.abs
def CubeRoot(x:Double) = process(y=> (2*y + x/(y*y))/3)(10)
def process(f:(Double)=>Double)(fg:Double) {
	def iterate(first:Double) {
		val next = f(first)
		println(next)
		if(isCloseEnough(next, fg)) next else iterate(next)
	}
	iterate(fg)
}
def isCloseEnough(x:Double, y:Double): Boolean = abs((x-y)/2) > tolerance
def tolerance = 0.0001

println(CubeRoot(120.0))
