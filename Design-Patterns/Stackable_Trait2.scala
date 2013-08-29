abstract class Operation {
	def calculate(price:Int)
	def getPrice():Int
}
class Product extends Operation {
	var price = 10
	def calculate(price:Int) = {
		this.price=price*2
	}
	def getPrice = price
}
trait ChangeOperation extends Operation {
	abstract override def calculate(price:Int) = super.calculate(price*2)
}
class Prod1 extends Product {
	override def calculate(price:Int) {
		this.price=price*10
	}	
}

var test = new Prod1

test.calculate(10)
println(test.getPrice)

test = new Prod1 with ChangeOperation
 
test.calculate(10)
println(test.getPrice)

