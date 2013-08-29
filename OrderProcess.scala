class Order(x:Int) {	
	val id:Int = 0
	def getId(): Int = id
	var prods = List[Prod]()
	def +(x:Prod):Unit = prods::=x
	def getOrderPrice():Int = calcPrice(
				p=>{
				var pr = 0
				for(x<-p) pr+=x.getPrice()
				pr
				},
				t=>{
				var tx = 0
				for(x<-t) tx+=(x.getPrice()/10)
				tx
			     	},
				d=>{
				var dc = 0
				for(x<-d)dc+=(x.getPrice()/20)
				dc
				})
	private def calcPrice(price:(List[Prod])=> Int, tax:(List[Prod])=>Int, disc:(List[Prod])=>Int): Int = {		
		 price(prods)+tax(prods)-disc(prods)
	}
	def getProducts(): List[Prod] = prods
}
class OrderList() {	
	var ordLst = List[Order]()
	def +(x:Order): Unit = ordLst::=x
	def processOrders(): Unit = {
		for(order <- ordLst){
			println("-----------------------")
		        for (prod <- order.getProducts())
				println("Product name-->>"+prod.getName()+" & Price-->>"+prod.getPrice())
			println(".")
			println("Order Price with Tax and Discounts-->>"+order.getOrderPrice())
		}
	}
}
abstract class Prod {
	def getName(): String	
	def getPrice(): Int
}

class Prod1(n:String, p:Int) extends Prod{
	val name = n
	val price = p
	def getName(): String = name
	def getPrice() : Int = price
}

object OrderDeal {
	def process(){
		val order1 = new Order(11)
		order1+(new Prod1("Cell Phone Guard", 10))
		order1+(new Prod1("Flip Flops", 25))
		order1+(new Prod1("Sun Glasses",212))

		val order2 = new Order(22)
		order2+(new Prod1("Aber Crombie Shirt", 75))
		order2+(new Prod1("Garmin GPS", 120))
		order2+(new Prod1("Stitching Machine", 55))
	
		val ordLst = new OrderList
		ordLst+order1
		ordLst+order2
		ordLst.processOrders()	
	}
}
OrderDeal.process()
