
case class Complex(real:Int, imag:Int) {
	
	def +(c:Complex):Complex = new Complex(this.real+c.real, this.imag+c.imag)
	def -(c:Complex):Complex = new Complex(this.real-c.real, this.imag-c.imag)
	def mod:Double = Math.sqrt(real*real+imag*imag)
}

object MyImplicits {
	
	implicit def convToInt(x:Int):Complex = new Complex(x,0)
	
}

object MyImplicitTest{
	
	import MyImplicits._
	print (3 + Complex(3,4))
}

MyImplicitTest



