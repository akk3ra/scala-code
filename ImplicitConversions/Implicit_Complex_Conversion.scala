import MyConversion._
case class Complex(x:Int, y:Int) {
	def +(c:Complex):Complex = Complex(c.x+x, c.y+y)
	def -(c:Complex):Complex = Complex(c.x-x, c.y-y)
	override def toString = x.toString + "+i"+y.toString
}

object MyConversion {

	implicit def intToComplex(x:Int):Complex = new Complex(x,0)
	implicit def tupToComplex(x:Tuple2[Int,Int]):Complex = new Complex(x._1,x._2)
}	

object MyTest {
	
	def myTest {
		
		println((Complex(1,2)+Complex(2,3)).toString+ "\n")
		println((35+Complex(3,5)).toString+ "\n")
		println(((11,22) - Complex(6,6)).toString+ "\n")

	}
}

MyTest.myTest
