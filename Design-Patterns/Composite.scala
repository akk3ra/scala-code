trait Product {
	
	def getValue(): Int
}
class Pen(x:Int) extends Product {
	
	val price = 10;
	var cost = 0;
	def getValue(): Int = {
		cost = price*x
		cost	
	}
}

class Pencil(x:Int) extends Product {
	val price = 5;
	var cost = 0;
	def getValue() : Int = {
		cost = price*x
		cost
	}
}
class CompProd() extends Product{
		
	var list = List[Product]()
	def addProd(x:Product): Unit = {
		list::=x
	}
	def getValue() : Int = {		
		var finalPrice = 0
		for(x <- list){
			finalPrice+=x.getValue()
		}
		finalPrice
	}
	
}
object MyComProd {
	
	val pen:Product = new Pen(3)
	val pencil:Product = new Pencil(5)
	
	val comProd:CompProd = new CompProd
	
	comProd.addProd(new Pen(4))
	comProd.addProd(new Pencil(5))
	comProd.addProd(new Pen(5))
	
	def display() : Unit = {
		println("The value of pen is-->>"+pen.getValue())
		println("The value of pencil is-->>"+pencil.getValue())
		println("The value of Composite Product is-->>"+comProd.getValue())
	}
}
MyComProd.display()
