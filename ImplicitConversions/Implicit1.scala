import ImplicitConversions._
class Complex(val x:Double, val y:Double) {
	def +(c:Complex):Complex = new Complex(c.x+this.x , c.y+this.y)
	def -(c:Complex):Complex = new Complex(c.x-this.x , c.y-this.y)

	override def toString = x+" + "+y+"i"
}
object ImplicitConversions{
	implicit def DoubleToComplex(x:Double) = new Complex(x,0.0)
	implicit def TupleToComplex(x:Tuple2[Double, Double]) = new Complex(x._1,x._2)
}
def addComplex {
	var c1:Complex = 3.5 + new Complex(2.3, 3.4)
	println(c1.toString)
	
	c1 = new Complex(2.3,3.4) + 3.5
	println(c1.toString)

	c1 = (3.6,7.8)
	
	println(c1+new Complex(5.1,6.1))
}
addComplex

