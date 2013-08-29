import Math.sqrt
import MyConversions._
class Complex(val real:Int, val imag:Int) {
	def mod: Double =Math.sqrt(real*real+imag*imag)
	def +(x:Complex):Complex = new Complex(this.real+x.real, this.imag+x.imag)
	def +(x:Int):Complex = new Complex(this.real+x, this.imag)
}

object MyConversions {
	implicit def myConv1(x:Int):Complex = new Complex(x, 0)
	implicit def myConv2(x:Tuple2[Int, Int]):Complex = new Complex(x._1, x._2)
}

def myTest {
	val x = new Complex(1,2) + new Complex(2,3)
	println(x.mod)
	
	val y = new Complex(3,4) + 5 // This will add the integer to the real part of the Complex number.
				     // Therefore no conversion is needed.
	println(y.mod)

	val z = 7 + (new Complex(9,10)) // Here the integer 7 does not have a method "+" defined which would
					// add itself to a complex number, therefore the impplicit conversion
					// takes place and converts the integer into a complex number first
					// and make 7 as new Complex(7,0) in which the imaginary part will be 0.
	println(z.mod)

	val q  = (3,7) + new Complex(1,4) // The Tuple does not have a "+" method defined which could add it to a
					  // complex number. Therefore the Tuple will be first converted into a 
					  // complex number and then added to the other complex number. Therefore
					  // the value (3,7) gets converted into new Complex(3,7) and gets added to
					  // new Complex(1,4)
	println(q.mod)

	println(((1,2)+(3,4)).mod) // Here both the tuples get implicitly converted into complex numbers and the addition
				   // takes place.
}
myTest
