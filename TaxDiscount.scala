class Order(id:Int) {
	
	val prods = List[Product]()
	def +(x:Product) = prods::=x
	def getProductList = prods
	def getOrderId = id
}

trait Product(n:String, p:Int) {
	var id = 0
	var name = n
	var price = p
	def getName = name
	def getId = id
	def getPrice = price
	def setPrice(x:Int) = price = x
	def setId(id:Int) = this.id = id
}

class Part(n:String, p:Int) extends Product(n,p)

class OrderList {
	val orders = List[Order]()
	def +(x:Order) = orders::=x
	def processOrders(f:(String)=>Int) {			
		for(order<-orders) {
			val for{
					prod<-order.getProductList
					if(f(prod.getName)>6) prod.setPrice(prod.getPrice-f(prod.getName))
					else prod.setPrice(prod.getPrice+f(prod.getName))
			}yield prod
		}
	}
}
