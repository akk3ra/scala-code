import Math.abs
def Sqrt(x:Double) = process(y=>(y+x/y)/2)(0.5)
def process(f:(Double)=>Double)(fg:Double){
	 def iterate(guess:Double): Double = {
	 val next = f(guess)
	 println(next)
	 if(isCloseEnough(guess, next)) next
	 else iterate(next)
	}
	iterate(fg)
}
def isCloseEnough(x:Double, y:Double) = abs((x-y)/x) < tolerance
val tolerance = 0.0001
println(Sqrt(1000.0))
