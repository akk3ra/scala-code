abstract class Product {
	def getName(): String
	def setPrice(x:Int):Unit
	def getPrice(): Int
}
class MyProd(n:String) extends Product {
	val name = n
	var price = 0
	def getName = name
	def setPrice(x:Int):Unit = {price = x}
	def getPrice = price
}
trait MyDiscount10 extends Product {
	abstract override def setPrice(x:Int):Unit = { super.setPrice(x*0.9)}
}
class MyProd1(n:String) extends MyProd(n)

var test = new MyProd1("Pencil")
test.setPrice(10)
println(test.getPrice)

test = new MyProd1(n:String) with MyDiscount10
test.setPrice(10)
println(test.getPrice)

