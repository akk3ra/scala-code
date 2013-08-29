class Rational(p:Int, q:Int) {
	
	require(q!=0)
	private val gcdVal = gcd(p,q)
	val num:Int = p/gcdVal
	val den:Int = q/gcdVal
	
	def this(r:Int) = this(r,1)

	def +(x:Int): Rational = new Rational(num+x*den, den)
	def +(x:Rational): Rational = new Rational(num*x.den + x.num*den, den*x.den)
	def -(x:Int): Rational = new Rational(num-x*den, den)
	def -(x:Rational): Rational = new Rational(num*x.den - x.num*den, den*x.den)
	def /(x:Int): Rational = new Rational(num, x*den) 
	def /(x:Rational): Rational = new Rational(num*x.den, den*x.num)
	def *(x:Int): Rational = new Rational(x*num, den)
	def *(x:Rational): Rational = new Rational(x.num*num, x.den*den)

	override def toString = num+" / "+den
	
	def gcd(x:Int, y:Int): Int = if(y==0) x else gcd(y, x%y)
	
}

val x = new Rational(3,2)
println("x-->> "+x.toString())
var y = new Rational(2,3)
println("y-->> "+y.toString())
println("x+y-->> "+(y+x))
var a = new Rational(3)
println("a-->> "+a.toString())
var b = new Rational(33,22)
println("b-->> "+b.toString())
println("a-b -->>"+(a-b))
var c = new Rational(3,3)
println("c-->> "+c.toString())
var d = new Rational(3,2)
println("d-->> "+d.toString())
println("c/d-->>"+c/d)
