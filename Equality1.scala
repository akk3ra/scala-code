import Math._
import scala.collection.immutable.HashSet

case class Product(val x:Int, val y:Int)
case class Order(val x:Int, val y:Int) {
	override def equals(other:Any):Boolean = other match {
		case other:Order => sqrt (other.x*other.x + other.y*other.y) == sqrt(this.x*this.x + this.y*this.y)
		case _ => false
	}
	override def hashCode:Int = (this.x+this.y)*41
}
object testEquality {
	var a = Product(1,2)
	var b = Product(1,2)
	println("---------Product Object------------")	
	println(a==b) // Prints true
	println(a eq b) // prints false
	println(a equals b) // prints true
	val c = Order(3,4)
	val d = Order(4,3)
	println("---------Order Object------------")	
	println(c==d) // Prints true
	println(c eq b) // prints false
	println(c equals d) // prints true
	println("---------Lists------------")	
	
	val e = Product(1,2)
	val f = Product(1,2)	
	println(HashSet(e) contains f)
	val g = Order(2,3)
	val h = Order(3,2)
	println(HashSet(g) contains h)
}
testEquality
