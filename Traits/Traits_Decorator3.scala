abstract class Product {
	def setPrice(x:Double)
	def getPrice:Double
}
class Computer extends Product{
	var price:Double = 0.0
	def setPrice(x:Double) = price = x
	def getPrice:Double = price
}
class KeyBoard extends Product{
	var price:Double = 0.0
	def setPrice(x:Double) = price = x
	def getPrice:Double = price
}
class ProductProcessor {
	var prods:List[Product] = List()
	def +(x:Product) = prods::=x
	
	def calPrice:Double = {
		var pri:Double = 0
		for(prod<-prods)
		   pri+=prod.getPrice 	
		   pri
		}
}
trait ApplyDiscount extends Product {
	abstract override def setPrice(x:Double) = super.setPrice(x*0.8)
}
object TestTraits {
	def myTest {
		val pp = new ProductProcessor
		val comp = new Computer with ApplyDiscount
		comp.setPrice(1200)
		pp+(comp)
		val keyb1 = new KeyBoard
		keyb1.setPrice(80)
		pp+(keyb1)
		println(pp.calPrice)
	}
}
TestTraits.myTest
